package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static int count = 0;

    static final Semaphore semaphore = new Semaphore(1);

    public static void addOne()throws InterruptedException{
        semaphore.acquire();
        try {
            count++;
        }finally {
            semaphore.release();
        }

    }

    public static void main(String[] args) {

       // TestSemaphore testSemaphore = new TestSemaphore();

        for(int i = 0; i < 10; i++){

            new Thread(() -> {
                try {
                    TestSemaphore.addOne();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }).start();

        }

        System.out.println(TestSemaphore.count);


    }

}
