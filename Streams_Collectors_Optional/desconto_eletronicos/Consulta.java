

import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        Produto p = new Produto(
                                produto.getCodigo(),
                                produto.getNome(),
                                produto.getCategoria(),
                                Math.round(produto.getPreco() * 0.85 * 100.0) / 100.0
                        );
                        return p;
                    }
                    return produto;
                })
                .collect(Collectors.toList());
    }
}
