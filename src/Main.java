import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        TextAnalyzer textAnalyzer = new TextAnalyzer();
//        textAnalyzer.menuOperation();

//        TextAnalyzer2 textAnalyzer2 = new TextAnalyzer2();
//        textAnalyzer2.textProcessing(textAnalyzer2.getText());

        UserCreator userCreator = new UserCreator();
        List<Optional<User>> users = userCreator.createUsers();
        userFilter(users);
    }

    public static void userFilter(List<Optional<User>> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = scanner.nextInt();
        Optional<User> userById = users.stream().map(Optional::get).filter(u -> u.getId() == id).findFirst();
        System.out.println(userById);
    }

}