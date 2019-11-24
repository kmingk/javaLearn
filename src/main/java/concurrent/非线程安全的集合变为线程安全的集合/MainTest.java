package concurrent.非线程安全的集合变为线程安全的集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        Collections.synchronizedList(list);
        

    }
    
    
    
}
