import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Student[] students;
    private static Book[] books;

    public static void main(String[] args) {

        int numberStudents = Constants.NUMBER_OF_STUDENTS;
        int numberBooks = Constants.NUMBER_OF_BOOKS;

        ExecutorService executorService = Executors.newFixedThreadPool(numberStudents);

        try {
            books = new Book[numberBooks];
            students = new Student[numberStudents];

            for(var i=0;i<numberBooks;++i) {
                books[i] = new Book(i + 1);
            }

            for(var i=0;i<numberStudents;++i) {
                students[i] = new Student(i + 1, books);
                executorService.execute(students[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            executorService.shutdown();

            for (Student student : students) {
                student.setShouldStop(true);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (!executorService.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }

            for (Student student : students) {
                student.printReadBooks();
            }
        }
    }
}