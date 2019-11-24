package concurrent;

public class DeadLockTest implements Runnable{

    int a,b;
    public DeadLockTest(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println("a + b = " + (a+b));
            }

        }
    }

    public native void aa();

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++){
            new Thread(new DeadLockTest(1,2), "ab").start();
            new Thread(new DeadLockTest(2,1),"ba").start();
        }


    }


}
