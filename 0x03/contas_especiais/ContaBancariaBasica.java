import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (valor > saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        double tarifa1 = 10.0;
        double tarifa2 = saldo * 0.10;
        return tarifa1 < tarifa2 ? tarifa1 : tarifa2;
    }

    public double calcularJurosMensal() {
        if (saldo <= 0) return 0;
        return saldo * (taxaJurosAnual / 12.0 / 100.0);
    }

    public void aplicarAtualizacaoMensal() {
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
