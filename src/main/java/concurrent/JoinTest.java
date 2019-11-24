package concurrent;

public class JoinTest {

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
        t1.start();

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
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("main..end");


    }

}
