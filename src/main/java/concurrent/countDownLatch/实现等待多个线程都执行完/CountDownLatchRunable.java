package concurrent.countDownLatch.实现等待多个线程都执行完;

import java.util.ArrayList;
import java.util.List;

public class CountDownLatchRunable implements Runnable {

    private List<String> list;
    private int i;
    public CountDownLatchRunable(int i, List<String> list){
        this.list = list;
        this.i = i;
    }
    @Override
    public void run() {
        if (1 == 1) {
            list = getOrder();
        }else {
            list = getContract();
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
