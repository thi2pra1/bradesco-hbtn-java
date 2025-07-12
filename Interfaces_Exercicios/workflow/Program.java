package Interfaces_Exercicios.workflow;

import atividades.*;

public class Program {
    public static void main(String[] args) {
        MaquinaWorkflow maquinaWorkflow = new MaquinaWorkflow();

        Workflow workflow1 = new Workflow();
        workflow1.registrarAtividade(new CarregarVideo());
        workflow1.registrarAtividade(new CodificarVideo());
        workflow1.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflow1);

        System.out.println("-----");

        Workflow workflow2 = new Workflow();
        workflow2.registrarAtividade(new CarregarVideo());
        workflow2.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflow2);

        System.out.println("-----");

        Workflow workflow3 = new Workflow();
        workflow3.registrarAtividade(new CarregarVideo());
        workflow3.registrarAtividade(new ModificarStatusVideo());
        workflow3.registrarAtividade(new EnviarEmail());

        maquinaWorkflow.executar(workflow3);
    }
}
