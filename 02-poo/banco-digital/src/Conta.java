import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private static int SEQUENCIAL = 1;
    protected Cliente cliente;
    protected List<String> extrato = new ArrayList<>();

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia(){
        return agencia;
    }
    
    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    @Override
    public void sacar(double valor){
        if (valor <= 0) {
            extrato.add("Tentativa de saque inválido: " + valor);
            System.out.println("Valor inválido");
            return;
        }
        if (this.saldo >= valor){
            this.saldo -= valor;
            extrato.add("Saque: -" + valor + " | Saldo: " + this.saldo);
        } else {
            extrato.add("Saque recusado (saldo insuficiente): " + valor);
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor){
        if (valor <= 0) {
            extrato.add("Tentativa de depósito inválido: " + valor);
            System.out.println("Valor inválido");
            return;
        }
        this.saldo += valor;
        extrato.add("Depósito: +" + valor + " | Saldo: " + this.saldo);
    }

    @Override
    public void transferir(IConta destino, double valor){
        if (valor <= 0) {
            extrato.add("Tentativa de transferência inválida: " + valor);
            System.out.println("Valor inválido");
            return;
        }
        if (this.saldo >= valor){
            this.sacar(valor);
            destino.depositar(valor);
            extrato.add("Transferência para conta " + ((Conta)destino).getNumero() + ": -" + valor + " | Saldo: " + this.saldo);
        } else {
            extrato.add("Transferência recusada (saldo insuficiente): " + valor);
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n=== Extrato ===");
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: 000" + this.agencia + " | Conta: 000" + this.numero + " | Saldo: $" + this.saldo);
        if (extrato.isEmpty()) {
            System.out.println("Sem movimentações.");
        } else {
            for (String linha : extrato) {
                System.out.println(linha);
            }
        }
        System.out.println("=== Fim do Extrato ===\n");
    }

    @Override
    public String toString(){
        return "Conta{" +
                "titular=" + cliente.getNome() +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
