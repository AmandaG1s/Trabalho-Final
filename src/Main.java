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
    public static void validaCPF(String cpf){
        if(cpf.length() != 11){
            System.out.println("CPF invalido");
        }
    }

    public static void main(String[] args) {
        UniversidadeSist universidade = new UniversidadeSist();

        try {
            //Está adicionando todos os estudantes carregados do arquivo
            universidade.getEstudantes().addAll(Persistencia.carregarArq("estudantes.dat"));
            universidade.getProfessores().addAll(Persistencia.carregarArq("professores.dat"));
            universidade.getDisciplinas().addAll(Persistencia.carregarArq("disciplinas.dat"));
            universidade.getTurmas().addAll(Persistencia.carregarArq("turmas.dat"));
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
            System.out.println("| 5. Cadastrar Disciplina |");
            System.out.println("| 6. Listar Disciplina    |");
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
                    //validando o cpf
                    String cpf = "";
                    while(cpf.length() != 11){
                        System.out.print("CPF (somente numeros): ");
                        cpf = sc.nextLine();
                        validaCPF(cpf);
                    }
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = sc.nextLine();
                    System.out.print("CRA: ");
                    double cra = sc.nextDouble();

                    if(tipoEstudante == 1){
                        System.out.println("Periodo: ");
                        int periodo = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Tema de estagio: ");
                        String temaEst = sc.nextLine();

                        universidade.cadastrarEstudante(new EstudanteGrad(nome, cpf, dataNascimento, cra, periodo, temaEst));

                    } else if (tipoEstudante == 2) {
                        System.out.println("Tema da pesquisa: ");
                        sc.nextLine();
                        String temaP = sc.nextLine();
                        universidade.cadastrarEstudante(new EstudantePosGrad(nome, cpf, dataNascimento, cra, temaP));
                    } else{
                        System.out.println("Opção invalida! Escolha uma que seja valida");
                    }

                    break;

                case 2:
                    universidade.listarEstudantes();
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
                    Disciplina disciplina = null;
                    sc.nextLine();
                    int test = 0;
                    boolean t2 = true;
                    while(test < 3) {
                        System.out.println("Código da Disciplina: ");
                        String codDic = sc.nextLine();

                        for(Disciplina disc : universidade.getDisciplinas()){
                            if(disc.getCodigo().equals(codDic)) {
                                disciplina = disc;
                                test = 3;
                                t2 = true;
                                break;
                            }
                        }
                        if(disciplina == null){
                            System.out.println("Essa disciplina não é valida, tente outra que seja");
                            test++;
                            t2 = false;
                        }

                    }
                    if(t2){
                        System.out.print("Semestre: ");
                        String semestre = sc.nextLine();
                        System.out.print("Ano: ");
                        int anoT = sc.nextInt();
                        universidade.cadastrarTurma(new Turma(disciplina, semestre, anoT));
                        break;
                    }


                case 8:
                    for(Turma t : universidade.getTurmas()){
                        System.out.println(t);
                        System.out.println("-------------------------------------");

                    }
                    break;
            }
        } while (opcao != 9);


        try {
            Persistencia.salvarArq(universidade.getEstudantes(), "estudantes.dat");
            Persistencia.salvarArq(universidade.getProfessores(), "professores.dat");
            Persistencia.salvarArq(universidade.getDisciplinas(), "disciplinas.dat");
            Persistencia.salvarArq(universidade.getTurmas(), "turmas.dat");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
