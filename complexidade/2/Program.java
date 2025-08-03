public class Program {

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        PessoasArray p = new PessoasArray();

        try {
            p.buscaBinaria("Otavio");
            p.buscaBinaria("Isabela");
            p.buscaBinaria("Anderson");
        } catch (IllegalArgumentException e) {
            System.out.println("Tempo de execução: " + (System.nanoTime() - inicio));
            throw e;
        }

        System.out.println("Tempo de execução: " + (System.nanoTime() - inicio));
    }
}
