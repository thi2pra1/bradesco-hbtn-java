public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeAtual, String nome) {
        setNome(nome);
        setSaudeAtual(saudeAtual); // Isso já define o status corretamente
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            this.saudeAtual = 0;
        } else if (saudeAtual > 100) {
            this.saudeAtual = 100;
        } else {
            this.saudeAtual = saudeAtual;
        }

        this.status = this.saudeAtual == 0 ? "morto" : "vivo";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
        // Caso nome seja inválido (null ou vazio), mantém o nome anterior
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }
}

