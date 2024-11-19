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

    public static <T> ArrayList<T> carregarArq(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            ArrayList<T> dados = (ArrayList<T>) ois.readObject();
            System.out.println("Dados carregados do arquivo: " + arquivo);
            System.out.println("Quantidade de itens carregados: " + dados.size());
            return dados;
        }
    }
}
