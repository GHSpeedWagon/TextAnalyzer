import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserCreator {
    static int id = 0;
    public List<Optional<User>> createUsers() {
        return IntStream.range(0, 10)
                .mapToObj(i -> createRandomOptionalUser())
                .toList();
    }

    private Optional<User> createRandomOptionalUser() {
        Random random = new Random();
        int randomNumber = 10 + random.nextInt(11);
        String randomName = String.valueOf(Names.getRandomName());
        id++;
        return Optional.of(new User(randomNumber, randomName, id));
    }
}
