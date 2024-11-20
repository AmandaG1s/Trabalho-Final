import java.io.Serializable;

public class Disciplina implements Serializable {

        private String codigo;
        private String nome;
        private int cargaHoraria;

    /**
     * @nota O {@code serserialVersionUID} é uma assinatura de versões da classe. Tendo a função de ajudar a evitar problemas
     * de compatibilidade na serialização. É usado quando implementa a Serializable, automaticamente um identificador único.
     *
     * > Private    usado dentro da propria classe;
     * > static     indica que a variável pertence à classe, e não a uma instância dela especifica dela;
     * > final      indica que a variável é constante e seu valor não pode ser alterado após ser inicializado.
     * > long       É o tipo correto para o identificador de versão exigido pela serialização.
     */
    private static final long serialVersionUID = 1L;


    public Disciplina(){}
    public Disciplina(String codigo, String nome, int cargaHoraria) {
            this.codigo = codigo;
            this.nome = nome;
            this.cargaHoraria = cargaHoraria;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getCargaHoraria() {
            return cargaHoraria;
        }

        public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
        }

        public String toString(){
            return "Código: " + codigo + "\n" +
                    "Nome:  " + nome   + "\n" +
                    "Carga Horária: " + cargaHoraria + "\n";
        }


}
