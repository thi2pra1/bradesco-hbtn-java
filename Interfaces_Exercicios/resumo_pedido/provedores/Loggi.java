package provedores;

public class Loggi implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double porcentagem = (peso > 5000) ? 0.12 : 0.04;
        return new Frete(valor * porcentagem, TipoProvedorFrete.LOGGI);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}

