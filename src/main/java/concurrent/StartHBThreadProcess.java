package concurrent;

import concurrent.base.MyThread;
import domain.User;

/**
 *  thread.start()方法happens-before于任何线程内的操作中的操作
 */
public class StartHBThreadProcess {

    public static void main(String[] args) {

        User user = new User();
        user.setUsername("u1111111");

        MyThread myThread = new MyThread(0L, user);
        user.setUsername("u22222");

        myThread.start();

        try {
            Thread.sleep(100);
        }catch (InterruptedException ex){}

        System.out.println("end....: " + user.getUsername());


    }

}
