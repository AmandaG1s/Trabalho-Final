import java.io.Serializable;

public class EstudantePosGrad extends Estudante implements Requisitos, Serializable {

    private String temaPesquisa;

    public EstudantePosGrad(){}
    public EstudantePosGrad(String nome, String cpf, String dataNascimento, double cra, String temaPesquisa) {
        super(nome, cpf, dataNascimento, cra);
        this.temaPesquisa = temaPesquisa;
    }

    public String getTemaPesquisa() {
        return temaPesquisa;
    }

    public void setTemaPesquisa(String temaPesquisa) {
        this.temaPesquisa = temaPesquisa;
    }

    public String getDescricao(){
        return "nome: " + nome +
                "\ntipo: Pós Graduacao" +
                "\ntema de pesquisa: " + temaPesquisa;
    }

    @Override
    //exception lançada caso a função seja chamada em um estudante de pos grad
    public void defineEstagio() {
        throw new UnsupportedOperationException("Estudantes de pós graduação não realizam estágio!!");
    }

    @Override
    public Boolean aprovado() {
        if(getCra() > 60){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tema de Pesquisa: " + temaPesquisa;
    }
}
