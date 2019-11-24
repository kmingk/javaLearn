package concurrent.lockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start..");
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }

                //LockSupport.parkNanos(5000);
                LockSupport.parkUntil(50000);
                System.out.println("sum:" + sum);

            }
        });

        t.start();

//        try{
//          //  Thread.sleep(1000);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        System.out.println("unpark before");
     //   LockSupport.unpark(t);
        System.out.println("unpark after");



    }

}
