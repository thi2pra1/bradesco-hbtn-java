package Interfaces_Exercicios.workflow;

public class Email implements CanalNotificacao {
    public void notificar(Mensagem mensagem) {
        System.out.printf("[EMAIL] {%s} - %s\n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}

