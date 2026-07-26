import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Harry Potter", "J.K. Rowling", 223, Type.FANTASY),
                new Book("The Hobbit", "J.R.R. Tolkien", 310, Type.FANTASY),
                new Book("Dune", "Frank Herbert", 412, Type.SCI_FI),
                new Book("Pride Prejudice", "Jane Austen", 279, Type.ROMANCE),
                new Book("The Alchemist", "Paulo Coelho", 208, Type.FICTION),
                new Book("Atomic Habits", "James Clear", 320, Type.SELF_HELP),
                new Book("Clean Code", "Robert C. Martin", 464, Type.TECH),
                new Book("Effective Java", "Joshua Bloch", 416, Type.TECH),
                new Book("Deep Work", "Cal Newport", 304, Type.SELF_HELP),
                new Book("Thinking Fast", "Daniel Kahneman", 499, Type.PSYCHOLOGY),
                new Book("The Shining", "Stephen King", 447, Type.HORROR),
                new Book("Dracula", "Bram Stoker", 418, Type.HORROR),
                new Book("Moby Dick", "Herman Melville", 635, Type.CLASSIC),
                new Book("War Peace", "Leo Tolstoy", 1225, Type.CLASSIC),
                new Book("Crime Punishment", "Fyodor Dostoevsky", 671, Type.CLASSIC),
                new Book("The Odyssey", "Homer", 541, Type.CLASSIC),
                new Book("A Game of Thrones", "George R.R. Martin", 694, Type.FANTASY),
                new Book("To Kill a Mockingbird", "Harper Lee", 336, Type.CLASSIC),
                new Book("The Lord of the Rings", "J.R.R. Tolkien", 1178, Type.FANTASY),
                new Book("One Hundred Years of Solitude", "Gabriel García Márquez", 417, Type.FICTION)
        );

        books.stream().filter(b -> b.getTitle().trim().split("\\s+").length == 2)
                .forEach(System.out::println);
    }
}