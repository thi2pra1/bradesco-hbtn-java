import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String linha;
            System.out.println("Digite linhas de texto. Digite 'sair' para encerrar.");

            while (true) {
                linha = scanner.nextLine();
                if ("sair".equalsIgnoreCase(linha)) {
                    break;
                }
                writer.write(linha);
                writer.newLine();
            }

            System.out.println("Arquivo '" + fileName + "' criado e conteúdo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
