package concurrent.countDownLatch.实现等待多个线程都执行完;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ManyThreadAllDone {

    public static void main(String[] args) {

        // 等待两个线程都执行完
        CountDownLatch countDownLatch = new CountDownLatch(2);
        List<String> order = new ArrayList<>();
        Thread orderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                order.addAll(getOrder());
                countDownLatch.countDown();
            }
        });
        orderThread.start();
        System.out.println("aaa...");

        List<String> contract = new ArrayList<>();
        Thread contractThread = new Thread(new Runnable() {
            @Override
            public void run() {
                contract.addAll(getContract());
                countDownLatch.countDown();
            }
        });
        contractThread.start();

        System.out.println("bb....");
        try {
            countDownLatch.await();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("cc..");

        for(int i = 0; i < 3; i++){
            System.out.println(order.get(i));
            System.out.println(contract.get(i));
        }

    }

    public static List<String> getOrder(){

        try {
            Thread.sleep(500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return new ArrayList<String>(){{
            this.add("order1");
            this.add("order2");
            this.add("order3");

        }};
    }

    public static List<String> getContract(){

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return new ArrayList<String>(){{
            this.add("contract1");
            this.add("contract2");
            this.add("contract3");

        }};

    }

}
