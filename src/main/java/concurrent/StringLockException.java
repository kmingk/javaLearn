package concurrent;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * 验证相同的String变量是同一把锁
 *   多次执行，结果分析
 *      alock .. in
         alock .. out
         block .. in
         block .. out
         oLock1 .. in
         oLock2 .. in
         oLock2 .. out
         oLock1 .. out

    alock执行完，才会执行bLock,
    但是以同样方式加锁的，oLock2确会早于oLock1执行完
 */

public class StringLockException {

    public static void main(String[] args) {

        String aLock = "a";
        String bLock = "a";

        Object oLock1 = new Object();
        Object oLock2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (aLock){

                   System.out.println("alock .. in");
                   try {
                       Thread.sleep(1000);
                   }catch (InterruptedException ex){}
                   System.out.println("alock .. out");

               }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bLock){

                    System.out.println("block .. in");
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException ex){}
                    System.out.println("block .. out");

                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){}

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oLock1){

                    System.out.println("oLock1 .. in");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){}
                    System.out.println("oLock1 .. out");

                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (oLock2){

                    System.out.println("oLock2 .. in");
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException ex){}
                    System.out.println("oLock2 .. out");

                }
            }
        });

        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        }catch (InterruptedException e){}


    }

}
