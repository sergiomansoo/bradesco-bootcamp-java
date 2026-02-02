public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limite = 100.0;
    }

    public ContaCorrente(Cliente cliente, double limite) {
        super(cliente);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void sacar(double valor){
        if (valor <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        if (this.saldo + this.limite >= valor) {
            this.saldo -= valor;
            this.extrato.add("Saque: -" + valor + " | Saldo: " + this.saldo);
        } else {
            this.extrato.add("Saque recusado (limite excedido): " + valor);
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n=== Extrato Conta Corrente ===");
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.agencia + " | Conta: " + this.numero + " | Saldo: " + this.saldo + " | Limite: " + this.limite);
        if (extrato.isEmpty()) {
            System.out.println("Sem movimentações.");
        } else {
            for (String linha : extrato) {
                System.out.println(linha);
            }
        }
        System.out.println("=== Fim do Extrato ===\n");
    }
}