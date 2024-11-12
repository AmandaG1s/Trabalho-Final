import java.io.Serializable;
import java.util.Scanner;

public class EstudanteGrad extends Estudante implements Requisitos {

    private String temaEstagio;
    private int periodo;


    public EstudanteGrad(String nome, String cpf, String dataNascimento, double cra, int periodo) {
        super(nome, cpf, dataNascimento, cra);
        this.periodo = periodo;
    }

    public String getTemaEstagio() {
        return temaEstagio;
    }

    public void setTemaEstagio(String temaEstagio) {
        this.temaEstagio = temaEstagio;
    }

    @Override
    public void defineEstagio() {
        if(periodo < 2){
            throw new UnsupportedOperationException("Estudantes de graduação só podem realizar estagio apos o segundo período completo!!");
        }
        else{
            System.out.printf("Qual o tema do estagio?: ");
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
        return "nome: " + nome +
                "\ntipo: Pós Graduacao" +
                "tema de estagio: " + temaEstagio;
    }
}
