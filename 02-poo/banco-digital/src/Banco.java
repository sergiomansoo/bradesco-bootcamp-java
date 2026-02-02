import java.util.ArrayList;
import java.util.List;

public class Banco {
   private String nome;
   private List<Cliente> clientes = new ArrayList<>();
   private List<Conta> contas = new ArrayList<>();

   public Banco(String nome) {
       this.nome = nome;
   }

   public void adicionarCliente(Cliente cliente) {
       this.clientes.add(cliente);
   }

   public ContaCorrente criarContaCorrente(Cliente cliente) {
       ContaCorrente cc = new ContaCorrente(cliente);
       this.contas.add(cc);
       return cc;
   }

   public ContaPoupanca criarContaPoupanca(Cliente cliente) {
       ContaPoupanca cp = new ContaPoupanca(cliente);
       this.contas.add(cp);
       return cp;
   }

   public Conta buscarConta(int numero) {
       for (Conta c : contas) {
           if (c.getNumero() == numero) return c;
       }
       return null;
   }

   public boolean transferir(int numeroOrigem, int numeroDestino, double valor) {
       Conta origem = buscarConta(numeroOrigem);
       Conta destino = buscarConta(numeroDestino);
       if (origem == null || destino == null) {
           System.out.println("Conta não encontrada");
           return false;
       }
       origem.transferir(destino, valor);
       return true;
   }

   public void imprimirRelatorio() {
       System.out.println("\n=== Relatório do Banco: " + this.nome + " ===");
       for (Conta c : contas) {
           System.out.println(c);
       }
       System.out.println("=== Fim do Relatório ===\n");
   }
}
