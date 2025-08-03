import java.util.*;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;

    public GerenciamentoDeContatos() {
        contatos = new LinkedHashMap<>();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " já existe!");
            return;
        }

        for (Contato c : contatos.values()) {
            if (c.getEmails().contains(email)) {
                System.out.println("Erro: Email já utilizado!");
                return;
            }
        }

        Contato novoContato = new Contato();
        novoContato.adicionarTelefone(telefone);
        novoContato.adicionarEmail(email);
        contatos.put(nome, novoContato);
        System.out.println("Contato " + nome + " adicionado com sucesso!");
    }

    public void exibirContatos() {
        List<String> nomesOrdenados = new ArrayList<>(contatos.keySet());
        Collections.sort(nomesOrdenados); // ordena os nomes alfabeticamente

        for (String nome : nomesOrdenados) {
            Contato contato = contatos.get(nome);
            System.out.println("Nome: " + nome);
            contato.exibirContato();
            System.out.println("-------------------------------");
        }
    }


    public void buscarContato(String nome) {
        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + nome);
            contato.exibirContato();
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();

        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");

        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();

        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");

        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");

        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");

        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}
