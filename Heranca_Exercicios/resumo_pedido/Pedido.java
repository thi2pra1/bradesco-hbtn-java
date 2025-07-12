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
        double totalProdutos = 0;
        for (ItemPedido item : itens) {
            totalProdutos += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return totalProdutos * (1 - percentualDesconto / 100);
    }

    public void apresentarResumoPedido() {
        Locale.setDefault(new Locale("pt", "BR"));

        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0;

        for (ItemPedido item : itens) {
            String tipo = (item.getProduto() instanceof produtos.Livro) ? "Livro" : "Dvd";
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;

            System.out.printf(Locale.getDefault(),
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, titulo, preco, quantidade, totalItem);

            totalProdutos += totalItem;
        }

        System.out.println("----------------------------");

        double desconto = totalProdutos * (percentualDesconto / 100);

        System.out.printf(Locale.getDefault(), "DESCONTO: %.2f\n", desconto);
        System.out.printf(Locale.getDefault(), "TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf(Locale.getDefault(), "TOTAL PEDIDO: %.2f\n", calcularTotal());
        System.out.println("----------------------------");
    }
}

