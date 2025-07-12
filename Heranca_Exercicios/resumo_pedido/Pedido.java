import java.util.Locale;
import produtos.Produto;
import produtos.Livro;
import produtos.Dvd;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        double desconto = total * (percentualDesconto / 100.0);
        return total - desconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            double preco = produto.obterPrecoLiquido();
            int quant = item.getQuantidade();
            double total = preco * quant;
            totalProdutos += total;

            String tipo = produto instanceof Livro ? "Livro" : "Dvd";
            System.out.printf(
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo,
                    getTitulo(produto),
                    preco,
                    quant,
                    total
            );
        }

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - desconto;

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }

    private String getTitulo(Produto produto) {
        // Usa reflexão porque título é private e não foi criado um getter.
        // Mas se você tiver um getTitulo() em Produto, pode usar diretamente.
        try {
            java.lang.reflect.Field tituloField = Produto.class.getDeclaredField("titulo");
            tituloField.setAccessible(true);
            return (String) tituloField.get(produto);
        } catch (Exception e) {
            return "TÍTULO DESCONHECIDO";
        }
    }
}

