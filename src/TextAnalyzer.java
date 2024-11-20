import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private static final Scanner scanner = new Scanner(System.in);

    public void menuOperation() {
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        boolean continueOperation = true;

        while (continueOperation) {
            System.out.println("\nTake operation:");
            System.out.println("1 - Find word");
            System.out.println("2 - Change word");
            System.out.println("3 - Count words");
            System.out.println("4 - Exit");

            int choice = Integer.valueOf(scanner.nextInt());
            scanner.nextLine();
            continueOperation = selectionProcessing(choice, scanner, text);
        }
    }

    private  boolean selectionProcessing(int choice, Scanner scanner, String text) {
        final String text1 = text;

        if (choice == 1) {
            Runnable r = () -> System.out.println("Write word to find");
            String findWord = scanner.nextLine();

            int index = text.indexOf(findWord);
            Predicate<String> containsWord = (textToCheck) -> textToCheck.contains(findWord);
            System.out.println("Result: " + containsWord.test(text));
        } else if (choice == 2) {
            System.out.println("Enter word to replace:");
            String wordToReplace = scanner.nextLine();
            System.out.println("write new word:");
            String newWord = scanner.nextLine();
            if (newWord.contains(" ")) {
                newWord = Arrays.stream(newWord.split(" ")).collect(Collectors.joining(""));
            }
            BiFunction<String, String, String> replaceWord = (oldWord, replacement) -> text1.replace(oldWord, replacement);
            text = replaceWord.apply(wordToReplace, newWord);
            System.out.println("new text: " + text);
        } else if (choice == 3) {
            Function<String, Integer> countWords = (textToCount) -> textToCount.split("\\s+").length;
            System.out.println("Count of words: " + countWords.apply(text));
        } else if (choice == 4) {
            return false;
        } else {
            System.out.println("Incorrect choice");
        }
        return true;
    }
}
