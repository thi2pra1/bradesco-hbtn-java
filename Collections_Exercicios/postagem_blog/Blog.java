import java.util.*;

public class Blog {
    private Set<Post> postagens;

    public Blog() {
        this.postagens = new HashSet<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagens.contains(postagem)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new TreeMap<>();
        for (Post post : postagens) {
            Categorias cat = post.getCategoria();
            contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getAutor().equals(autor)) {
                posts.add(post);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getCategoria() == categoria) {
                posts.add(post);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new TreeMap<>();
        for (Post post : postagens) {
            Categorias cat = post.getCategoria();
            mapa.putIfAbsent(cat, new TreeSet<>());
            mapa.get(cat).add(post);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post post : postagens) {
            Autor autor = post.getAutor();
            mapa.putIfAbsent(autor, new TreeSet<>());
            mapa.get(autor).add(post);
        }
        return mapa;
    }
}
