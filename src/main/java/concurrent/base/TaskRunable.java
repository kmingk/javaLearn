package concurrent.base;

import lombok.Data;

import java.util.List;
import java.util.concurrent.Callable;

@Data
public class TaskRunable implements Runnable {

    private List<String> stringList;

    private Long sleepTime;

    public TaskRunable(List<String> params, long sleepTime) {
        this.stringList = params;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(this.sleepTime);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }


}
