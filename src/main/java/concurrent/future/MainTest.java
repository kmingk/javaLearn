package concurrent.future;

import concurrent.base.TaskCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(1);
      //  submitRunable(pool);

        // submitCallable(pool);

        // submitRunableResult 略
        // 该方法用于补足Runable没有返回值的遗憾
        // pool.submit()


    }

    /**
     * call可以有返回值
     * @param pool
     */
    private static void submitCallable(ExecutorService pool) {
        MyCallable myCallable = new MyCallable();
        try {
            Future<String> future = pool.submit(myCallable);
            if(!future.isDone()){
                System.out.println("not done...");
            }
            String result = future.get();
            System.out.println("结果： " + result);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * submit(Runable) 方法仅仅可以断言任务是否结束
     * @param pool
     */
    private static void submitRunable(ExecutorService pool) {
        Future future = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start.....");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("end.....");
            }
        });

        while (!future.isDone()){
            System.out.println("no........");
        }

        System.out.println("is done.......");
    }

}
