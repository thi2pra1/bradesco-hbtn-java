import java.util.List;
import java.util.Comparator;

public class Consulta {
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .max(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }
}
