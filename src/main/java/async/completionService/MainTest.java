package async.completionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

    public static void main(String[] args) {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(service);

        cs.submit(() -> getPrice1());
        cs.submit(() -> getPrice2());
        cs.submit(() -> getPrice3());

        for (int i = 0; i < 3; i++) {
            try {
                Integer integer = cs.take().get();
                System.out.println("..." + integer);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    public static Integer getPrice1(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return 1;

    }

    public static Integer getPrice2(){
        try {
            Thread.sleep(500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return 2;
    }

    public static Integer getPrice3(){
        try {
            Thread.sleep(1500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return 3;

    }

}
