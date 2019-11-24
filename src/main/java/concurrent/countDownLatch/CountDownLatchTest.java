package concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public void go(int threadCount, Runnable task){

        // 用于暂停所有线程，先不执行
        CountDownLatch startGate = new CountDownLatch(1);
        // 统计执行完毕的线程个数，如果有未执行完的线程，则阻塞
        CountDownLatch endGate = new CountDownLatch(threadCount);

        Long startTime = System.currentTimeMillis();
        for(int i = 0; i < threadCount; i++){

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        task.run();
                    }catch (InterruptedException ex){

                    }finally {
                        endGate.countDown();
                    }
                }
            });
            thread.start();

        }

        System.out.println("所有线程开始执行：");
        startGate.countDown();

        System.out.println("endGate   await");
        try {
            endGate.await();
        }catch (InterruptedException ex){}

        System.out.println("process tiem:" + (System.currentTimeMillis() - startTime));

    }

    public static void main(String[] args) {

        CountDownLatchTest test = new CountDownLatchTest();
        test.go(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("..........");
            }
        });
    }

}
