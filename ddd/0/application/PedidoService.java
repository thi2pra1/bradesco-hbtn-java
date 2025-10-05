package application;


import domain.Cliente;
import domain.Pedido;
import domain.Produto;
import infrastructure.PedidoRepository;


public class PedidoService {


    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    public Pedido criarPedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }

        Pedido pedido = new Pedido(cliente);
        pedidoRepository.salvar(pedido);
        return pedido;
    }


    public void adicionarProduto(String pedidoId, Produto produto) {
        if (pedidoId == null || pedidoId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do pedido não pode ser nulo ou vazio");
        }
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado com ID: " + pedidoId);
        }

        pedido.adicionarProduto(produto);
        pedidoRepository.salvar(pedido);
    }


    public void pagarPedido(String pedidoId) {
        if (pedidoId == null || pedidoId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do pedido não pode ser nulo ou vazio");
        }

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado com ID: " + pedidoId);
        }

        pedido.pagar();
        pedidoRepository.salvar(pedido);
    }


    public void cancelarPedido(String pedidoId) {
        if (pedidoId == null || pedidoId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do pedido não pode ser nulo ou vazio");
        }

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado com ID: " + pedidoId);
        }

        pedido.cancelar();
        pedidoRepository.salvar(pedido);
    }
}
