import java.util.Scanner;
public class ContaTerminal{
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int numero;
        String agencia;
        String nomeCliente;
        float saldo;
        System.out.println("Por favor, digite o número da Agência:");
        numero=sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor, digite o nome da Agência:");
        agencia=sc.nextLine();
        System.out.println("Por favor, digite o nome do cliente:");
        nomeCliente=sc.nextLine();
        System.out.println("Por favor, digite o saldo do cliente:");
        saldo=sc.nextFloat();
        System.out.println("Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+agencia+", conta "+numero+" e seu saldo "+saldo+" já está disponível para saque");
    }
}
