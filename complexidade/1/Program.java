public class Program {

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        PessoasArray p = new PessoasArray();

        try {
            p.buscaLinear("Otavio");
            p.buscaLinear("Isabela");
            p.buscaLinear("Anderson");
        } catch (IllegalArgumentException e) {
            System.out.println("Tempo de execução: " + (System.nanoTime() - inicio));
            throw e;

        System.out.println("Tempo de execução: " + (System.nanoTime() - inicio));
        }
    }

}
