import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UniversidadeSist implements Serializable { // Implementa Serializable para serialização
    private ArrayList<Estudante> estudantes;
    private ArrayList<Professor> professores;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;


    public UniversidadeSist() {
        estudantes = new ArrayList<>();
        professores = new ArrayList<>();
        disciplinas = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }


    public void cadastrarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void cadastrarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void listarEstudantes(){
        if(estudantes.isEmpty()){
            System.out.println("Nunhum estudante foi cadastrado!");
        }
        System.out.println("\nEstudantes: ");
        for(Estudante estudante: estudantes){
            System.out.println(estudante.toString());
            System.out.println("---------------------------------------------");
        }

    }

}