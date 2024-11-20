import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Amanda Gomes;
 * João Gabriel Nunes;
 * João Gabriel Viana
 */
public class Main {

    /**
     * @nota Essas constantes representam os nomes dos arquivos onde os dados dos estudantes, professores, diciplinas e turmas
     * serão armazenadas e carregadas. Cada uma delas contém um nome do arquivo que será usado pelo sistema. O uso das constantes
     * foi para evitar a duplicação de valores, otimizar a manutenção e atualização do código.
     *
     */
    private static final String ARQUIVO_ESTUDANTES = "estudantes.dat";
    private static final String ARQUIVO_PROFESSORES = "professores.dat";
    private static final String ARQUIVO_DISCIPLINAS = "disciplinas.dat";
    private static final String ARQUIVO_TURMAS = "turmas.dat";

    public static void main(String[] args) {
        UniversidadeSist universidade = new UniversidadeSist();

        try {
            //Está adicionando todos os estudantes carregados do arquivo
            universidade.getEstudantes().addAll(Persistencia.carregarArq(ARQUIVO_ESTUDANTES));
            universidade.getProfessores().addAll(Persistencia.carregarArq(ARQUIVO_PROFESSORES));
            universidade.getDisciplinas().addAll(Persistencia.carregarArq(ARQUIVO_DISCIPLINAS));
            universidade.getTurmas().addAll(Persistencia.carregarArq(ARQUIVO_TURMAS));
        } catch (Exception e) {
            System.out.println("Nenhum arquivo encontrado.\n");
        }

        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("--------------------------");
            System.out.println("| \t       Menu:         |");
            System.out.println("| 1. Cadastrar Estudante |");
            System.out.println("| 2. Listar Estudantes   |");
            System.out.println("| 3. Cadastrar Professor |");
            System.out.println("| 4. Listar Professor    |");
            System.out.println("| 5. Cadastrar Diciplina |");
            System.out.println("| 6. Listar Diciplina    |");
            System.out.println("| 7. Cadastrar Turma     |");
            System.out.println("| 8. Listar Turma        |");
            System.out.println("| 9. Sair                |");
            System.out.println("--------------------------");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nQual o tipo estudante quer cadastrar?");
                    System.out.println("1.Estudante Graduação");
                    System.out.println("2. Estudante Pos-Graduação");
                    int tipoEstudante = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = sc.nextLine();
                    System.out.print("CRA: ");
                    double cra = sc.nextDouble();

                    if(tipoEstudante == 1){
                        System.out.println("Periodo: ");
                        int periodo = sc.nextInt();
                        System.out.println("Tema de estagio: ");
                        String temaEst = sc.nextLine();

                        universidade.cadastrarEstudante(new EstudanteGrad(nome, cpf, dataNascimento, cra, periodo, temaEst));

                    } else if (tipoEstudante == 2) {
                        System.out.println("Tema da pesquisa: ");
                        String temaP = sc.nextLine();
                        universidade.cadastrarEstudante(new EstudantePosGrad(nome, cpf, dataNascimento, cra, temaP));
                    }


                    break;
                case 2:
                    for (Estudante e : universidade.getEstudantes()) {
                        System.out.println(e);
                        System.out.println("---------------------------------------------");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeProfessor = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfProfessor = sc.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimentoProfessor = sc.nextLine();
                    System.out.print("Novo Contrato (true/false): ");
                    boolean novoContrato = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Departamento: ");
                    String departamento = sc.nextLine();

                    universidade.cadastrarProfessor(new Professor(nomeProfessor, cpfProfessor, dataNascimentoProfessor, novoContrato, departamento));
                    break;

                case 4:
                    for (Professor p : universidade.getProfessores()) {
                        System.out.println(p);
                        System.out.println("-------------------------------------");
                    }
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Código da Disciplina: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nome da Disciplina: ");
                    String nomeDic = sc.nextLine();
                    System.out.print("Carga Horária: ");
                    int cargH = sc.nextInt();

                    universidade.cadastrarDisciplina(new Disciplina(codigo,nomeDic,cargH));
                    break;

                case 6:
                    for (Disciplina d : universidade.getDisciplinas()) {
                        System.out.println(d);
                        System.out.println("-------------------------------------");
                    }
                    break;

                case 7:
                    sc.nextLine();
                    System.out.println("Código da Diciplina: ");
                    String codDic = sc.nextLine();
                    Disciplina disciplina = null;

                    for(Disciplina disc : universidade.getDisciplinas()){
                        if(disc.getCodigo().equals(codDic)){
                            disciplina = disc;
                            break;
                        }else {
                            System.out.println("Essa disciplina não foi encontrada!");
                            break;
                        }
                    }
                    System.out.print("Semestre: ");
                    String semestre = sc.nextLine();
                    System.out.print("Ano: ");
                    int anoT = sc.nextInt();
                    universidade.cadastrarTurma(new Turma(disciplina, semestre, anoT));
                    break;

                case 8:
                    for(Turma t : universidade.getTurmas()){
                        System.out.println(t);
                        System.out.println("-------------------------------------");

                    }
                    break;
            }
        } while (opcao != 9);


        try {
            Persistencia.salvarArq(universidade.getEstudantes(), ARQUIVO_ESTUDANTES);
            Persistencia.salvarArq(universidade.getProfessores(), ARQUIVO_PROFESSORES);
            Persistencia.salvarArq(universidade.getDisciplinas(), ARQUIVO_DISCIPLINAS);
            Persistencia.salvarArq(universidade.getTurmas(), ARQUIVO_TURMAS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
