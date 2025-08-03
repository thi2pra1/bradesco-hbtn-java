import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            boolean isFirstLine = true;

            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                linha = linha.replace("\uFEFF", "");

                String[] campos = linha.split(",");

                System.out.printf("Funcionário: %s\n", campos[0]);
                System.out.printf("Idade: %s\n", campos[1]);
                System.out.printf("Departamento: %s\n", campos[2]);
                System.out.printf("Salarial: %s\n", campos[3]);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
