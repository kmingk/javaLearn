package concurrent.cache;

import java.util.HashMap;
import java.util.Map;

public class Memery<A,V> implements Computable<A, V> {

    private final Map<A,V> cache = new HashMap<>();
    private final Computable<A,V> c;

    public Memery(Computable<A,V> computable){
        this.c = computable;
    }

    public synchronized V compute(A args) {
        V result = cache.get(args);
        if(null == result){
            result = c.compute(args);
            cache.put(args, result);
        }
        return result;
    }
}
