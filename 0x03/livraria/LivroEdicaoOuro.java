public class LivroEdicaoOuro extends Livro {

    public LivroEdicaoOuro(String titulo, String autor, double preco) throws exceptions.AutorInvalidoException, exceptions.LivroInvalidoException {
        super(titulo, autor, preco);
    }

    @Override
    public double getPreco() {
        // Acrescenta 30% sobre o preço original
        return super.getPreco() * 1.3;
    }
}
