package concurrent.TransferAccount;


import java.util.ArrayList;
import java.util.List;

public class Allocator {

    private Allocator(){}

    private static class AllcatorFactory{
        public static Allocator instance = new Allocator();
    }

    public static Allocator getInstance(){
        return AllcatorFactory.instance;
    }

    private List<Object> locked = new ArrayList<>();

    public synchronized Boolean apply(Object o1, Object o2){
        if(locked.contains(o1) || locked.contains(o2)){
            return false;
        }else {
            locked.add(o1);
            locked.add(o2);
            return true;
        }
    }

    public synchronized void free(Object o1, Object o2){
        locked.remove(o1);
        locked.remove(o2);
    }


}
