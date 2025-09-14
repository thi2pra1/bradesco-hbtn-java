
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterio) {
        List<Produto> filtrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (criterio.test(produto)) {
                filtrados.add(produto);
            }
        }
        return filtrados;
    }
}
