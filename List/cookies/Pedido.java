import java.util.ArrayList;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie cookie : cookies) {
            total += cookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int totalRemovido = 0;

        ArrayList<PedidoCookie> novaLista = new ArrayList<>();

        for (PedidoCookie cookie : cookies) {
            if (cookie.getSabor().equals(sabor)) {
                totalRemovido += cookie.getQuantidadeCaixas();
            } else {
                novaLista.add(cookie);
            }
        }

        cookies = novaLista;
        return totalRemovido;
    }
}
