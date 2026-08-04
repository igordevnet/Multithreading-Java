import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final String DIRECTORY = System.getProperty("user.dir") + "/test/";

    public static void main(String[] args) throws IOException {
        Files.createDirectories(Paths.get(DIRECTORY));
        Main app = new Main();

        List<Person> people = app.generatePeople(10000);

        long start = System.currentTimeMillis();
        people.forEach(Main::save);
        System.out.println("Time taken sequential: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        people.parallelStream().forEach(Main::save);
        System.out.println("Time taken parallel: " + (System.currentTimeMillis() - start));

    }

    private static void save(Person person) {
        try (FileOutputStream fos =
                new FileOutputStream(new File(DIRECTORY + person.getId() + ".txt")))
        {} catch (IOException ex) {
            ex.fillInStackTrace();
        }
    }

    private List<Person> generatePeople(int num) {
        return Stream.iterate(0, n -> n + 1)
                .limit(num)
                .map(Person::new)
                .collect(Collectors.toList());
    }
}