import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> lista, int numero) {
        return lista.indexOf(numero);
    }

    public static void adicionarNumero(List<Integer> lista, int numero) throws Exception {
        if (buscarPosicaoNumero(lista, numero) != -1) {
            throw new Exception("Numero jah contido na lista");
        }
        lista.add(numero);
    }

    public static void removerNumero(List<Integer> lista, int numero) throws Exception {
        int pos = buscarPosicaoNumero(lista, numero);
        if (pos == -1) {
            throw new Exception("Numero nao encontrado na lista");
        }
        lista.remove(pos);
    }

    public static void substituirNumero(List<Integer> lista, int numeroSubstituir, int numeroSubstituto) {
        int pos = buscarPosicaoNumero(lista, numeroSubstituir);
        if (pos == -1) {
            lista.add(numeroSubstituto);
        } else {
            lista.set(pos, numeroSubstituto);
        }
    }
}
