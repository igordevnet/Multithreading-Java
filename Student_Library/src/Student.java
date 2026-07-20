import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Student implements Runnable {

    private final int id;
    private final Book[] books;
    private final Random random;

    private boolean shouldStop;
    private Map<String, Integer> readBooks;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
        this.readBooks = new HashMap<>();
    }

    @Override
    public void run() {
        while (!shouldStop) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);

            try {
                var book = books[bookId];
                if (book.read(this)) {
                    readBooks.merge(book.toString(), 1, Integer::sum);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }

    public void printReadBooks() {
        readBooks.forEach( (book, times) -> System.out.println(this + " has read " + book + " " + times + " times"));
    }

    @Override
    public String toString() {
        return "Student #" + id;
    }
}
