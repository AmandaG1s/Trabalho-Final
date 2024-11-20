import java.io.Serializable;
import java.util.List;

public abstract class Estudante extends Pessoa implements Serializable {
    private double cra;
    private static final long serialVersionUID = 1L;

    public Estudante(){}
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

    @Override
    public abstract String getDescricao();

    /**
     * @note
     * Na função toString é feito uma verificação, usa-se o equals (função do java) para comparar as duas string e a partir disso
     * direcionar para o tipo específico
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                                  "CRA: " + cra;
    }
}
