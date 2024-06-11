package Main;

import javax.swing.*;
import java.util.ArrayList;

import Pessoas.Pessoa;
import Pessoas.Aluno;
import Pessoas.Professor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[10];
        Professor[] professores = new Professor[10];
        int contAlunos = 0;
        int contProfessores = 0;

        int opcao;
        do {
            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Digite uma opção:\n"
                                    + "1 - Adicionar Aluno.\n"
                                    + "2 - Adicionar Professor.\n"
                                    + "3 - Calcular Nota Final do Aluno.\n"
                                    + "4 - Consultar Alunos.\n"
                                    + "5 - Consultar Professores.\n"
                                    + "6 - Deletar Aluno.\n"
                                    + "7 - Deletar Professor.\n"
                                    + "8 - Sair."));
            switch(opcao){
                case 1:
                    Aluno aluno = inserirAluno();
                    alunos[contAlunos] = aluno;
                    contAlunos++;
                    break;
                case 2:
                    Professor professor = inserirProfessor();
                    professores[contProfessores] = professor;
                    contProfessores++;
                    break;
                case 3:
                    calcularNotaFinal(alunos, contAlunos);
                    break;
                case 4:
                    //consultarAlunos(alunos, contAlunos);
                    for (int i = 0; i < contAlunos; i++) {
                        JOptionPane.showMessageDialog
                                (null, alunos[i]);
                    }
                    break;
                case 5:
                    consultarProfessores(professores, contProfessores);
                    break;
                case 6:
                    deletarAluno(alunos, contAlunos);
                    contAlunos--;
                    break;
                case 7:
                    deletarProfessor(professores, contProfessores);
                    contProfessores--;
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! Tente novamente.");
            }
        } while (opcao != 8);
    }

    public static Aluno inserirAluno() {
        String nome = JOptionPane.showInputDialog("Nome do Aluno:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno:"));
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Nota 1 do Aluno:"));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Nota 2 do Aluno:"));
        return new Aluno(nome, idade, nota1, nota2);
    }

    public static Professor inserirProfessor() {
        String nome = JOptionPane.showInputDialog("Nome do Professor:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Professor:"));
        String disciplina = JOptionPane.showInputDialog("Disciplina do Professor:");
        return new Professor(nome, idade, disciplina);
    }

    public static void calcularNotaFinal(Aluno[] alunos, int contAlunos) {
        String nome = JOptionPane.showInputDialog("Nome do Aluno para calcular a nota final:");
        for (int i = 0; i < contAlunos; i++) {
            if (alunos[i].getNome().equalsIgnoreCase(nome)) {
                double notaFinal = alunos[i].calcularNotaFinal();
                JOptionPane.showMessageDialog(null, "Nota final do aluno " + nome + ": " + notaFinal);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
    }

    public static void consultarAlunos(Aluno[] alunos, int contAlunos) {
        StringBuilder listaAlunos = new StringBuilder("Alunos:\n");
        for (int i = 0; i < contAlunos; i++) {
            listaAlunos.append(alunos[i].toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaAlunos.toString());
    }

    public static void consultarProfessores(Professor[] professores, int contProfessores) {
        StringBuilder listaProfessores = new StringBuilder("Professores:\n");
        for (int i = 0; i < contProfessores; i++) {
            listaProfessores.append(professores[i].toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProfessores.toString());
    }

    public static void deletarAluno(Aluno[] alunos, int contAlunos) {
        String nome = JOptionPane.showInputDialog("Digite o nome do Aluno a ser deletado:");
        for (int i = 0; i < contAlunos; i++) {
            if (alunos[i].getNome().equalsIgnoreCase(nome)) {
                alunos[i] = alunos[contAlunos -1];
                alunos[contAlunos - 1] = null;
                JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
    }

    public static void deletarProfessor(Professor[] professores, int contProfessores) {
        String nome = JOptionPane.showInputDialog("Digite o nome do Professor a ser deletado:");
        for (int i = 0; i < contProfessores; i++) {
            if (professores[i].getNome().equalsIgnoreCase(nome)) {
                professores[i] = professores[contProfessores - 1];
                professores[contProfessores - 1] = null;
                JOptionPane.showMessageDialog(null, "Professor deletado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Professor não encontrado!");
    }
}
