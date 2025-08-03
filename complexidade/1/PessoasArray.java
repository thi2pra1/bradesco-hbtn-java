public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos", "Daniela", "Eduardo",
                "Fabio", "Gustavo", "Hingrid", "Isabela", "Joao", "Leise", "Maria",
                "Norberto", "Otavio", "Paulo", "Quirino", "Renata", "Sabata",
                "Tais", "Umberto", "Vanessa", "Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public void buscaLinear(String nome) {
        nome = nome.intern();
        System.out.println("Procurando pelo nome: \"" + nome + "\"");
        int posicaoEncontrada = -1;

        // Percorre todo o array, imprimindo o indice e checando o nome
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Passando pelo indice:" + i);
            if (nomes[i] == nome) {
                posicaoEncontrada = i;
            }
        }

        if (posicaoEncontrada != -1) {
            System.out.println("Nome pesquisado é " + nome + " que está na posição " + posicaoEncontrada);
        } else {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }

}
