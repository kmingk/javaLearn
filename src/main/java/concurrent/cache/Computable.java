package concurrent.cache;

public interface Computable<A,V> {
    V compute(A args);
}
