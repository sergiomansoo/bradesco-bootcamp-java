public interface IConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(IConta destino, double valor);
    void imprimirExtrato();
}