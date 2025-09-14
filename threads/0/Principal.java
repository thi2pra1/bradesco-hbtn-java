
public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        ThreadContador t1 = new ThreadContador(contador);
        ThreadContador t2 = new ThreadContador(contador);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
