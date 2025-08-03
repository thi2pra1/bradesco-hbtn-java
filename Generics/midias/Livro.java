public class Livro extends Midia {
    private int edicao;

    public Livro(String nome, int edicao) {
        super(nome);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }
}

public class Video extends Midia {
    private int duracao;

    public Video(String nome, int duracao) {
        super(nome);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }
}

public class Jornal extends Midia {
    private int quantidadeArtigos;

    public Jornal(String nome, int quantidadeArtigos) {
        super(nome);
        this.quantidadeArtigos = quantidadeArtigos;
    }

    public int getQuantidadeArtigos() {
        return quantidadeArtigos;
    }
}
