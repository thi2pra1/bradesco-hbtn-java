package Interfaces_Exercicios.workflow;

public class Slack implements CanalNotificacao {
    public void notificar(Mensagem mensagem) {
        System.out.printf("[SLACK] {%s} - %s\n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}

