package concurrent.concurrentExample.DoubleCheckSingletonFailInConcurrent;


// 多线程环境下双重检查锁创建单例失败分析


/*
 new 操作不是原子操作，分为以下：
    1.分配一块内存M
    2.在内存M上初始化Singleton对象
    3.M的地址赋值给Singleton变量

 由于指令重排，执行的过程可能是：
    1 -> 3 -> 2
    在此场景下，当执行完 new->3 （此时instance已经有了地址，但是地址没有赋值）,
    此时切换时间片，另一个线程开始执行，在在第一次非空判断时，由于 == 比较的
    是地址，此时已经执行完  new->3,instance的地址不为空，所以返回instance，
    但是instance地址中没有进行过初始化，所有会有空指针异常。

*/

public class ADoubleCheckSingletonFail {

    public static void main(String[] args) {

        for (Long i = 0L; i < 100000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton.getInstance().play();
                }
            }).start();
        }

    }

}

