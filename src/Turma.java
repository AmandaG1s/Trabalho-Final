import java.io.Serializable;

public class Turma implements Serializable {
    private Disciplina disciplina;
    private String semestre;
    private int ano;



    public Turma(Disciplina disciplina, String semestre, int ano) {
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.ano = ano;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDiciplina(Disciplina diciplina) {
        this.disciplina = diciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString(){
        return "Disciplina: " + disciplina.getNome() + "\n" +
                "Semestre: "  + semestre   + "\n" +
                "Ano: "       + ano        + "\n" ;
    }
}
