import java.io.Serializable;
import java.util.Scanner;

public class EstudanteGrad extends Estudante implements Requisitos, Serializable {

    private String temaEstagio;
    private int periodo;

    public EstudanteGrad(){}
    public EstudanteGrad(String nome, String cpf, String dataNascimento, double cra, int periodo, String temaEstagio) {
        super(nome, cpf, dataNascimento, cra);
        this.periodo = periodo;
        this.temaEstagio = temaEstagio;
    }

    public String getTemaEstagio() {
        return temaEstagio;
    }

    public void setTemaEstagio(String temaEstagio) {
        this.temaEstagio = temaEstagio;
    }

    @Override
    public void defineEstagio() {
        //exception lançada caso o estudante nao tenha concluido o segundo perio
        if(periodo < 2){
            throw new UnsupportedOperationException("Este estudante nao pode estagiar pois nao concluiu o segundo periodo");
        }
        else{
            System.out.printf("Tema do estagio: ");
            Scanner sc = new Scanner(System.in);
            temaEstagio = sc.nextLine();
        }
    }

    @Override
    public Boolean aprovado() {
        if (getCra() > 60)
            return true;
        else
            return false;
    }

    @Override
    public String getDescricao() {
        return  "nome: " + nome +
                "\ntipo: Pós Graduacao" +
                "tema de estagio: " + temaEstagio;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tema do Estágio: " + temaEstagio + "\n" +
                "Período: " + periodo;
    }
}
