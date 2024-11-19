import java.io.Serializable;

public class Disciplina implements Serializable {

        private String codigo;
        private String nome;
        private int cargaHoraria;

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
