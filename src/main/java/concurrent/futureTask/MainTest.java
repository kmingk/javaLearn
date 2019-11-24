package concurrent.futureTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MainTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(1);

        FutureTask<String> task = new FutureTask<String>(() -> {
            System.out.println("strat");
            Thread.sleep(1000);
            System.out.println("end");
            return "futureTask over";
        });

        pool.submit(task);

        try {
            if(!task.isDone()){
                System.out.println("no done");
            }
            String result = task.get();
            System.out.println("result:" + result);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
