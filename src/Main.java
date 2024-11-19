import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String ARQUIVO_ESTUDANTES = "estudantes.dat";
    private static final String ARQUIVO_PROFESSORES = "professores.dat";
    private static final String ARQUIVO_DISCIPLINAS = "disciplinas.dat";
    private static final String ARQUIVO_TURMAS = "turmas.dat";

    public static void main(String[] args) {
        UniversidadeSist universidade = new UniversidadeSist();

        try {
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
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Listar Estudantes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sc.nextLine(); // Limpar buffer
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = sc.nextLine();
                    System.out.print("CRA: ");
                    double cra = sc.nextDouble();
                    universidade.cadastrarEstudante(new Estudante(nome, cpf, dataNascimento, cra));
                    break;
                case 2:
                    for (Estudante e : universidade.getEstudantes()) {
                        System.out.println(e);
                    }
                    break;
            }
        } while (opcao != 3);

        // Salvar dados
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
