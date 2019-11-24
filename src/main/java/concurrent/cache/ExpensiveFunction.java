package concurrent.cache;

public class ExpensiveFunction implements Computable<String, Integer> {
    @Override
    public Integer compute(String args) {
        System.out.println("long time compute");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return new Integer(args);
    }
}
