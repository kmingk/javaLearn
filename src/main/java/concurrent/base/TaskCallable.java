package concurrent.base;

import lombok.Data;

import java.util.List;
import java.util.concurrent.Callable;

@Data
public class TaskCallable implements Callable<List<String>> {

    private List<String> stringList;
    private Long sleepTime;

    public TaskCallable(List<String> params, Long sleepTime){
        this.stringList = params;
        this.sleepTime = sleepTime;
    }

    @Override
    public List<String> call() throws Exception {
        try {
            Thread.sleep(this.sleepTime);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return this.stringList;
    }
}
