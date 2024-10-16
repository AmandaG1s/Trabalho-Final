public class Estudante extends Pessoa {
    private double cra;
    private String tipo; // se é pos-graduação ou graduação
    private String extersao; // se faz estágio ou pesquisa

    public Estudante(String nome, String cpf, String dataNascimento, double cra, String tipo, String extersao) {
        super(nome, cpf, dataNascimento);
        this.cra = cra;
        this.tipo = tipo;
        this.extersao = extersao;
    }

    public double getCra() {
        return cra;
    }

    public void setCra(double cra) {
        this.cra = cra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExtersao() {
        return extersao;
    }

    public void setExtersao(String extersao) {
        this.extersao = extersao;
    }

    /**
     * @note
     * Na função toString é feito uma verificação, usa-se o equals (função do java) para comparar as duas string e a partir disso
     * direcionar para o tipo específico
     */
    public String toString(){
        return super.toString() +
                "CRA: " + cra + "\n" +
                "Qual seu tipo(Graduação ou Pós-Graduação): " + tipo + "\n" +
                (tipo.equals("Graduação") ? "Estágio Supervisionado: " : "Tema de Pesquisa: ") + extersao + "\n";
    }
}
