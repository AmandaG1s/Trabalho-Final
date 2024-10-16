public class Main {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Amanda", "11122233300", "18/03/2005", 8.0, "Graduação", "Estágio em TI");
        Estudante estudante2 = new Estudante("João Gabriel", "44455566600", "12/10/2003", 8.5, "Pós-Graduação", "Pesquisa em SQL");

        Professor professor = new Professor("Bruno", "77788899900", "21/09/1985", false, "Computação");

        Disciplina disciplina = new Disciplina("AA000", "Programação Orientada a Objeto", 90);
        Disciplina disciplina2 = new Disciplina("BB111", "Estruturas de Dados", 60);

        Turma turma = new Turma(disciplina2, "2024.2", 2024);


        System.out.println("Estudantes: ");
        System.out.println(estudante);
        System.out.println(estudante2);

        System.out.println("\nProfessor:");
        System.out.println(professor);

        System.out.println("\nDisciplina: ");
        System.out.println(disciplina);
        System.out.println(disciplina2);

        System.out.println("\nTurma: ");
        System.out.println(turma);
    }


}