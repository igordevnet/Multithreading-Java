import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> employees = List.of(
                new Person("Alice", 30, "Engineering"),
                new Person("Bob", 45, "Human Resources"),
                new Person("Charlie", 28, "Marketing"),
                new Person("Diana", 35, "Sales"),
                new Person("Eve", 41, "Finance"),
                new Person("Frank", 29, "Engineering"),
                new Person("Grace", 33, "Product Management"),
                new Person("Henry", 50, "Legal"),
                new Person("Ivy", 26, "Customer Support"),
                new Person("Jack", 38, "Engineering"),
                new Person("Karen", 42, "Human Resources"),
                new Person("Leo", 31, "Marketing"),
                new Person("Mia", 27, "Design"),
                new Person("Noah", 39, "Sales"),
                new Person("Olivia", 34, "Finance"),
                new Person("Paul", 47, "Operations"),
                new Person("Quinn", 25, "Engineering"),
                new Person("Rachel", 36, "Customer Support"),
                new Person("Sam", 44, "IT Security"),
                new Person("Tom", 32, "Product Management")
        );

        var result = employees.stream().collect(Collectors.partitioningBy(p -> p.getAge() < 30,
                Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println(result);
    }
}