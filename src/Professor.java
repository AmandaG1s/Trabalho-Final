public class Professor extends Pessoa{
    private boolean novoContrato;
    private String departamento;

    public Professor(String nome, String cpf, String dataNascimento, boolean novoContrato, String departamento) {
        super(nome, cpf, dataNascimento);
        this.novoContrato = novoContrato;
        this.departamento = departamento;
    }

    public String getDescricao() {
        return "Professor do departamento de " + departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String toString(){
        return super.toString() + "\n" +
                ((novoContrato) ? "Docente foi contratado recentemente" : "Docente é antigo na instituição") + novoContrato + "\n" +
                "Departamento: " + departamento + "\n";
    }


}
