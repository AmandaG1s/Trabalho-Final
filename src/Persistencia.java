import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    /**
     * @note Essa classe é responsavel por salvar e carregar os objetos dentro da lista (ArrayList<T>) para arquivos,
     * isso é feito a partir do serialização; Usando os fluxos de entrada e saida dos objetos(ObjectInputStream e ObjectOutputStream).
     * Caso a operação seja realizada com sucesso, será apresentada uma mensagem de sucesso, do contrario aparecerá uma de erro.
     * @param <T> o tipo genérico dos dados da lista.
     * @param dados lista de dados a ser salva.
     * @param arquivo nome do arquivo que os dados serão armazenados.
     * @throws IOException caso ocorra um erro durante as gravação no arquivo ela é chamada.
     */

    public static <T> void salvarArq(ArrayList<T> dados, String arquivo) throws IOException {

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            os.writeObject(dados);
            System.out.println("Dados salvos no arquivo: " + arquivo);
            System.out.println("Quantidade de itens salvos: " + dados.size());
        }
    }

    /**
     *
     * @param arquivo nome dos dados a ser carregado.
     * @return irá retornar uma lista de objetos do tipo genérico lidos do arquivo.
     * @nota Caso não exista a lista, será criada uma nova.
     *
     * Caso o arquivo não seja encontrado, uma mensagem é exibida no console -> {@code FileInputStream}
     * Caso ocorra um erro ao ler os dados do arquivo, a exceção é registrada e uma lista vazia é retornada -> {@code ClassNotFoundException} ou {@code IOException}
     */
    public static <T> ArrayList<T> carregarArq(String arquivo) {
        ArrayList<T> dados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            dados = (ArrayList<T>) ois.readObject();
            System.out.println("Dados carregados do arquivo: " + arquivo);
            System.out.println("Quantidade de itens carregados: " + dados.size());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + arquivo + ". Um novo arquivo será criado.");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados do arquivo " + arquivo + ": " + e.getMessage());
        }
        return dados;
    }
}
