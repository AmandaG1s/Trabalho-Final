import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    public static <T> void salvarArq(ArrayList<T> dados, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
        }
    }

    public static <T> ArrayList<T> carregarArq(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<T>) ois.readObject();
        }
    }
}
