import java.util.ArrayList;

public class ListaTodo {
    private ArrayList<Tarefa> tarefas;

    public ListaTodo() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == tarefa.getIdentificador()) {
                throw new IllegalArgumentException(
                        String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador())
                );
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int id) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == id) {
                t.marcarFeita();
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int id) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == id) {
                t.desfazer();
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.desfazer();
        }
    }

    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.marcarFeita();
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String estado = t.estahFeita() ? "X" : " ";
            System.out.printf("[%s]  Id: %d - Descricao: %s\n",
                    estado,
                    t.getIdentificador(),
                    t.getDescricao());
        }
    }
}
