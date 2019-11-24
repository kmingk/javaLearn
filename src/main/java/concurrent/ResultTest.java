package concurrent;

import concurrent.base.TaskCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultTest {

    public static void main(String[] args) {

        List<String> l1 = new ArrayList<String>(){{
            this.add("11");
            this.add("12");
            this.add("13");
        }};

        List<String> l2 = new ArrayList<String>(){{
            this.add("21");
            this.add("22");
            this.add("23");
        }};

        TaskCallable task1 = new TaskCallable(l1, 500L);
        TaskCallable task2 = new TaskCallable(l2, 2500L);

        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Future<List<String>> result2 = threadPool.submit(task2);
        final Future<List<String>> result1 = threadPool.submit(task1);

        List<String> all = new ArrayList<>();
        try {
//            all.addAll(result1.get());
//            all.addAll(result2.get());
//            for (String s : all) {
//                System.out.println("......" + s);
//            }

            System.out.println("2..start");
            long l = System.currentTimeMillis();
            for (String s : result2.get()) {
                System.out.println("result2......" + s);
            }
            System.out.println("end..time:" + (System.currentTimeMillis() - l));

            for (String s : result1.get()) {
                System.out.println("result1......" + s);
            }
        }catch (ExecutionException | InterruptedException ex){
            ex.printStackTrace();
        }

    }

}
