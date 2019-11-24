package concurrent.线程交替执行;

import java.util.concurrent.locks.LockSupport;

/*
    LockSupport知识点：
        1.先park(),线程会阻塞，然后unpark()线程会继续运行
        2.如果先unpark(),线程会继续运行，在park()时，线程不会阻塞

    猜想LockSupport的实现方式：
        LockSupport内部实现应该是有个Boolean值，park()设为true,
        unpark()设为false,当为true时线程阻塞，当为false时，线程继续运行
 */

public class LockSupportRealize {

    static Thread t1 = null, t2 = null;
    public static void main(String[] args) {

        char[] number = "12345".toCharArray();
        char[] letter = "abcde".toCharArray();

        t1 = new Thread(() -> {
            for (char c : number) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : letter) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();


    }

}
