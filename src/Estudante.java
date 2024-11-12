import java.util.List;

public class Estudante extends Pessoa {
    private double cra;

    public Estudante(String nome, String cpf, String dataNascimento, double cra) {
        super(nome, cpf, dataNascimento);
        this.cra = cra;
    }

    public double getCra() {
        return cra;
    }

    public void setCra(double cra) {
        this.cra = cra;
    }

    /**
     * @note
     * Na função toString é feito uma verificação, usa-se o equals (função do java) para comparar as duas string e a partir disso
     * direcionar para o tipo específico
     */
    public String toString(){
        return super.toString() +
                "CRA: " + cra + "\n";
    }
}
