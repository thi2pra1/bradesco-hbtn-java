public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Autor)) return false;
        Autor outro = (Autor) o;
        return this.nome.equals(outro.nome) && this.sobrenome.equals(outro.sobrenome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + sobrenome.hashCode();
    }

    @Override
    public int compareTo(Autor outro) {
        return this.toString().compareTo(outro.toString());
    }
}
