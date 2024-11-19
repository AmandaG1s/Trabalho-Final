import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    public static <T> void salvarArq(ArrayList<T> dados, String arquivo) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            os.writeObject(dados);
            System.out.println("Dados salvos no arquivo: " + arquivo);
            System.out.println("Quantidade de itens salvos: " + dados.size());
        }
    }

    public static <T> ArrayList<T> carregarArq(String arquivo) {
        ArrayList<T> dados = new ArrayList<>(); // Inicializa com uma lista vazia
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            dados = (ArrayList<T>) ois.readObject();
            System.out.println("Dados carregados do arquivo: " + arquivo);
            System.out.println("Quantidade de itens carregados: " + dados.size());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + arquivo + ". Um novo arquivo será criado.");
            // Não precisa fazer nada, já que 'dados' já foi inicializado como uma lista vazia.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados do arquivo " + arquivo + ": " + e.getMessage());
        }
        return dados;
    }
}
