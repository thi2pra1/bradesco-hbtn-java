package Heranca.salario;

public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double base = getSalarioFixo() * 0.20;
            double adicional = (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            return base + adicional;
        }
        return 0.0;
    }

}