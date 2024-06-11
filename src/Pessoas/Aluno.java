package Pessoas;

public class Aluno extends Pessoa {
    private double nota1;
    private double nota2;

    public Aluno(String nome, int idade, double nota1, double nota2) {
        super(nome, idade);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularNotaFinal() {
        return (nota1 + nota2) / 2;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nNota 1: " + nota1 + "\nNota 2: " + nota2;
    }

}
