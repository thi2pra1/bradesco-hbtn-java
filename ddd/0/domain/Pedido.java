package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido {


    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;


    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }


    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Não é possível adicionar produtos a um pedido que não está pendente");
        }
        this.produtos.add(produto);
    }


    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Não é possível remover produtos de um pedido que não está pendente");
        }
        this.produtos.remove(produto);
    }


    public void pagar() {
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Apenas pedidos pendentes podem ser pagos");
        }
        if (this.produtos.isEmpty()) {
            throw new IllegalStateException("Não é possível pagar um pedido sem produtos");
        }
        this.status = StatusPedido.PAGO;
    }


    public void cancelar() {
        if (this.status == StatusPedido.PAGO) {
            throw new IllegalStateException("Não é possível cancelar um pedido já pago");
        }
        this.status = StatusPedido.CANCELADO;
    }


    public String getId() {
        return id;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }


    public StatusPedido getStatus() {
        return status;
    }
}
