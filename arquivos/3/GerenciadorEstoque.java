import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite a quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());

                        estoque.adicionarProduto(nome, quantidade, preco);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Digite o ID do produto a ser excluído: ");
                        int idExcluir = Integer.parseInt(scanner.nextLine());
                        estoque.excluirProduto(idExcluir);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Estoque:");
                    estoque.exibirEstoque();
                    break;

                case 4:
                    try {
                        System.out.print("Digite o ID do produto: ");
                        int idAtualizar = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = Integer.parseInt(scanner.nextLine());

                        estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
