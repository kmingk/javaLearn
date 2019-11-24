package concurrent.future;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("callable  start.....");
        Thread.sleep(500);
        System.out.println("callable  end....");
        return "call over";
    }
}
