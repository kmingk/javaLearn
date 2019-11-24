package concurrent.concurrentExample;

import java.nio.channels.InterruptedByTimeoutException;

public class ActiveCountTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1..start");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("1..end");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2..start");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("2..end");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3..start");
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("3..end");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        while(Thread.activeCount() > 2){
            System.out.println("count:" + Thread.activeCount());
            if(Thread.activeCount() == 2){
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                Thread[] threads = new Thread[threadGroup.activeCount()];
                int enumerate = threadGroup.enumerate(threads);
                for (Thread thread : threads) {
                    System.out.println(thread.getName());
                }
            }
            Thread.yield();
        }

//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        System.out.println("..........end");



    }

}
