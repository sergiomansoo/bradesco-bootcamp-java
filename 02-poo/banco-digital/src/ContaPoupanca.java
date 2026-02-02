public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void renderJuros(double taxa) {
        if (taxa <= 0) {
            System.out.println("Taxa inválida");
            return;
        }
        double ganho = this.saldo * taxa;
        this.saldo += ganho;
        this.extrato.add("Rendimento: +" + ganho + " (taxa: " + taxa + ") | Saldo: " + this.saldo);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n=== Extrato Conta Poupança ===");
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.agencia + " | Conta: " + this.numero + " | Saldo: " + this.saldo);
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
