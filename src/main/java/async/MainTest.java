package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class MainTest {

    public static void main(String[] args) {

       // ExecutorService service = Executors.newFixedThreadPool(2);
      //  otherThreadRunAsync(service);

        //testCombine();

    }

    private static void testCombine() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + "  " + s2).join();

        System.out.println(result);
    }

    private static void otherThreadRunAsync(ExecutorService service) {
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        System.out.println("start..." + Thread.currentThread().getName());
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(2000);
                        }catch (InterruptedException ex){
                            ex.printStackTrace();
                        }
                        System.out.println("end..." + Thread.currentThread().getName());

                        return "task finished";
                    }
                },service);

        future.thenAccept(e -> System.out.println(e + "ok" + Thread.currentThread().getName()));

        System.out.println("main thread is running" + Thread.currentThread().getName());
    }

}
