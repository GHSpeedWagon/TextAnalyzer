import java.util.Random;

public enum Names {
    Artem,
    Dmytro,
    Vlad,
    Bob,
    John_Doe;

    private static final Random random = new Random();

    public static final Names getRandomName() {
        Names[] names = Names.values();
        return names[random.nextInt(values().length)];
    }
}
