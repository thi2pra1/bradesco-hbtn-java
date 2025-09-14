
public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario)
                .replace('.', ',');
    }

    public int getIdade() {
        return idade;
    }

    public String getCargo() {
        return cargo;
    }
}
