import java.util.Scanner;

class Cliente {
    String email;
    String senha;
    String cpf;

    Cliente(String email, String senha, String cpf) {
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }
}

class Roupa {
    String tipo;
    double preco;

    Roupa(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }
}

public class LojaRoupas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Cliente:");
        System.out.print("Email: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Senha: ");
        String senhaCliente = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = new Cliente(emailCliente, senhaCliente, cpfCliente);

        Roupa[] roupasDisponiveis = {
            new Roupa("Blusa", 49.90),
            new Roupa("Calça", 89.99),
            new Roupa("Jaqueta", 150.0)
        };

        System.out.println("\nRoupas disponíveis:");
        for (int i = 0; i < roupasDisponiveis.length; i++) {
            System.out.println((i+1) + ". " + roupasDisponiveis[i].tipo + ", Preço: R$" + roupasDisponiveis[i].preco);
        }

        System.out.print("\nEscolha o número da roupa que deseja comprar (separado por espaços): ");
        String escolhas = scanner.nextLine();
        String[] escolhasArray = escolhas.split(" ");

        double totalCompra = 0;
        for (String escolha : escolhasArray) {
            int indiceEscolha = Integer.parseInt(escolha) - 1;
            if (indiceEscolha >= 0 && indiceEscolha < roupasDisponiveis.length) {
                Roupa roupaEscolhida = roupasDisponiveis[indiceEscolha];
                totalCompra += roupaEscolhida.preco;
                System.out.println("Roupa escolhida: " + roupaEscolhida.tipo);
            }
        }

        System.out.println("\nTotal da Compra: R$" + totalCompra);

        scanner.close();
    }
}
