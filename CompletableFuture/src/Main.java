import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try (var service = Executors.newVirtualThreadPerTaskExecutor()) {
            var start = System.currentTimeMillis();

            CompletableFuture.supplyAsync(DbQuery::run, service)
                    .thenCombine(CompletableFuture
                            .supplyAsync(RestQuery::run, service),
                    (res1, res2) -> res1 + " " + res2)
                    .thenAccept(result -> {
                        System.out.println(result + " took " + ((System.currentTimeMillis() - start) / 1000) + " seconds to finish");
                    });
        }
    }
}