import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco Bradesco");

        System.out.println("Bem-vindo ao sistema bancário");
        System.out.println();

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Selecionar conta por número");
            System.out.println("3 - Listar contas");
            System.out.println("4 - Relatório do banco");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Escolha: ");

            String opc = sc.nextLine();
            System.out.println();
            switch (opc) {
                case "1":
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine().trim();
                    if (nome.isEmpty()) {
                        System.out.println();
                        System.out.println("Nome inválido.");
                        System.out.println();
                        break;
                    }
                    Cliente cliente = new Cliente(nome);
                    banco.adicionarCliente(cliente);

                    System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
                    String tipo = sc.nextLine().trim();

                    System.out.print("Depósito inicial (0 para nenhum): ");
                    double inicial = readDouble(sc);

                    if ("1".equals(tipo)) {
                        ContaCorrente cc = banco.criarContaCorrente(cliente);
                        if (inicial > 0) cc.depositar(inicial);
                        System.out.println();
                        System.out.println("Conta corrente criada. Número: " + cc.getNumero());
                        System.out.println();
                    } else if ("2".equals(tipo)) {
                        ContaPoupanca cp = banco.criarContaPoupanca(cliente);
                        if (inicial > 0) cp.depositar(inicial);
                        System.out.println();
                        System.out.println("Conta poupança criada. Número: " + cp.getNumero());
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Tipo de conta inválido.");
                        System.out.println();
                    }
                    break;
                case "2":
                    System.out.print("Número da conta: ");
                    int numero = readInt(sc);
                    Conta conta = banco.buscarConta(numero);
                    System.out.println();
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        System.out.println();
                        break;
                    }
                    accountMenu(sc, banco, conta);
                    break;
                case "3":
                    banco.imprimirRelatorio();
                    System.out.println();
                    break;
                case "4":
                    banco.imprimirRelatorio();
                    System.out.println();
                    break;
                case "0":
                    System.out.println("Saindo. Obrigado!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    System.out.println();
            }
        }
    }

    private static double readDouble(Scanner sc) {
        try {
            String s = sc.nextLine();
            if (s == null || s.trim().isEmpty()) return 0;
            return Double.parseDouble(s.replace(',', '.'));
        } catch (Exception e) {
            return 0; 
        }
    }

    private static int readInt(Scanner sc) {
        try {
            String s = sc.nextLine();
            if (s == null || s.trim().isEmpty()) return 0;
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0; 
        }
    }

    private static void accountMenu(Scanner sc, Banco banco, Conta conta) {
        while (true) {
            System.out.println();
            System.out.println("Conta selecionada: " + conta);
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Imprimir extrato");
            if (conta instanceof ContaPoupanca) System.out.println("5 - Ver rendimento (poupança)");
            System.out.println("0 - Voltar");
            System.out.println();
            System.out.print("Escolha: ");

            String opc = sc.nextLine();
            System.out.println();
            switch (opc) {
                case "1":
                    System.out.print("Valor a sacar: ");
                    double v = readDouble(sc);
                    conta.sacar(v);
                    System.out.println();
                    break;
                case "2":
                    System.out.print("Valor a depositar: ");
                    double d = readDouble(sc);
                    conta.depositar(d);
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Número da conta destino: ");
                    int dest = readInt(sc);
                    Conta destino = banco.buscarConta(dest);
                    System.out.println();
                    if (destino == null) {
                        System.out.println("Conta destino não encontrada.");
                        System.out.println();
                        break;
                    }
                    System.out.print("Valor a transferir: ");
                    double t = readDouble(sc);
                    conta.transferir(destino, t);
                    System.out.println();
                    break;
                case "4":
                    conta.imprimirExtrato();
                    break;
                case "5":
                    if (conta instanceof ContaPoupanca) {
                        double rendimento = conta.getSaldo() * 0.01; // 1% fixo
                        System.out.println();
                        System.out.println("Rendimento em 1 mês (1%): R$ " + String.format("%.2f", rendimento));
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("Opção inválida para este tipo de conta.");
                        System.out.println();
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    System.out.println();
            }
        }
    }
}
