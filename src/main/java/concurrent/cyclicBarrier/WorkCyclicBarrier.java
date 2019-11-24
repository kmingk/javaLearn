package concurrent.cyclicBarrier;

import java.util.Vector;
import java.util.concurrent.CyclicBarrier;

public class WorkCyclicBarrier extends Thread {

    private CyclicBarrier cyclicBarrier;
    private Vector<String> vector;

    private static volatile int index = 0;

    public WorkCyclicBarrier(CyclicBarrier cyclicBarrier, Vector<String> vec){
        this.cyclicBarrier = cyclicBarrier;
        this.vector = vec;
    }

    @Override
    public void run() {
        while (true) {
            String name = Thread.currentThread().getName();
            synchronized (cyclicBarrier){
                vector.add(name + index);
                index++;
            }
            System.out.println("开始等待：" + name);
            try {
                this.cyclicBarrier.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("业务处理完毕：" + name);
        }
    }
}
