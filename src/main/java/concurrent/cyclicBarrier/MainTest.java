package concurrent.cyclicBarrier;

import java.util.Vector;
import java.util.concurrent.*;

public class MainTest {

    public static void main(String[] args) {


        // 验证callback与下一回合的执行顺序
        //  结果：如果开启新的线程执行callback,不管callback是否执行完毕，
        //        都会开始下一回合
        //validateCallback();


        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("1..");
                    cyclicBarrier.await();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("2..");
                    cyclicBarrier.await();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    private static void validateCallback() {
        Vector<String> order = new Vector<>();
        Vector<String> contract = new Vector<>();

        // 取值的必须用同一个线程，否则可能会取值的索引对不上
        Executor executor = Executors.newFixedThreadPool(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            executor.execute(() -> {
                String remove = order.remove(0);
                String removeContract = contract.remove(0);
                System.out.println("callback:" + remove + "_" + removeContract);
            });
        });
        new WorkCyclicBarrier(cyclicBarrier, order).start();
        new WorkCyclicBarrier(cyclicBarrier, contract).start();
    }

    public static void callback(){
        try {
            Thread.sleep(2000);

            System.out.println("cyclicBarrier  callback");
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
