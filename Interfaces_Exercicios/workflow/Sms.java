
public class Sms implements CanalNotificacao {
    public void notificar(Mensagem mensagem) {
        System.out.printf("[SMS] {%s} - %s\n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}

