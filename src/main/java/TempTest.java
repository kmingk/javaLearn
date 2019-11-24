import domain.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TempTest {

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        createBusyThread();

        reader.readLine();
        Object lock = new Object();
        createLockThread(lock);


    }

    public static void createBusyThread(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ;
                }
            }
        }, "busyThread");
        thread.start();
    }

    public static void createLockThread(Object lock){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }, "lockThread");
        thread.start();
    }


}
