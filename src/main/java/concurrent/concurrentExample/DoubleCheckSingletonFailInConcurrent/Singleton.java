package concurrent.concurrentExample.DoubleCheckSingletonFailInConcurrent;

public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance(){
        if(null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void play(){
        System.out.println("Singleton..." + instance);
    }

}
