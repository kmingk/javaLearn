package concurrent.lockSupport;

public class WaitTest {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("start...");
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += 1;
                }
                synchronized (lock){
                    try {
                        lock.wait();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }

                System.out.println("sum:" + sum);

            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            System.out.println("aaaaaaaa");
        }

        synchronized (lock){
            System.out.println("唤醒");
            lock.notifyAll();
        }

    }

}
