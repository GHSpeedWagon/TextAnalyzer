import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextAnalyzer2 {
    private static final Scanner scanner = new Scanner(System.in);
    private String text = "";
    public String getText() {
        System.out.println("Enter text source:");
        System.out.println("1 - Get from file");
        System.out.println("2 - Enter by console");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Введіть шлях до файлу:");
            String filePath = scanner.nextLine();
            try {
                text = Files.readString(Paths.get(filePath));
            } catch (IOException e) {
                System.out.println("Помилка читання файлу: " + e.getMessage());
                return text;
            }
        } else if (choice == 2) {
            System.out.println("Enter text");
            return scanner.nextLine();
        }
        return text;
    }

    public void textProcessing(String text) {
        List<String> words = Arrays.stream(text.split(" "))
                .map(String::toLowerCase).toList();
        System.out.println("\nWords in text");
        System.out.println(words);
        System.out.println("\nEnter letter for filter");
        String filterLetter = scanner.nextLine();

        List<String> filteredWords = words.stream()
                .filter(w -> w.startsWith(filterLetter))
                .toList();
        System.out.println("Words starts with " + filterLetter + ":");
        System.out.println(filteredWords);

        List<String> sortedWords = words.stream().sorted().toList();
        System.out.println("\n Sorted words");
        System.out.println(sortedWords);

        long uniqueWordCount = words.stream()
                .distinct()
                .count();

        System.out.println("\nCount of unique words");
        System.out.println(uniqueWordCount);

    }
}
