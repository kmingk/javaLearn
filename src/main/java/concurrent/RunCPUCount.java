package concurrent;

import java.net.URI;
import java.net.URL;

public class RunCPUCount {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        URI uri = new URI("https:www.baidu.com");
                        URL url = new URL("https:www.baidu.com");
                        Object content = url.getContent();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("aaa.." + Thread.currentThread().getName());
                }
            }
        };

        Thread t1 = new Thread(runnable, "t1");
        t1.start();

        Thread t2 = new Thread(runnable, "t2");
        t2.start();

        Thread t3 = new Thread(runnable, "t3");
        t3.start();

        Thread t4 = new Thread(runnable, "t4");
        t4.start();

        Thread t5 = new Thread(runnable, "t5");
        t5.start();


    }


}
