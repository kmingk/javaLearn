package concurrent.TransferAccount;

public class NoDealLockMainTest {

    public static void main(String[] args) {

        while (true) {
            NoDeadLockAccount a = new NoDeadLockAccount();
            a.setBalance(200);

            NoDeadLockAccount b = new NoDeadLockAccount();
            b.setBalance(200);

            NoDeadLockAccount c = new NoDeadLockAccount();
            c.setBalance(200);


            NoDealLockRunable transAB = new NoDealLockRunable(a, b, 100);
            NoDealLockRunable transBC = new NoDealLockRunable(b, c, 100);

            Thread t1 = new Thread(transAB, "ab");
            t1.start();
            Thread t2 = new Thread(transBC, "bc");
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
            }

            if(a.getBalance() != 100
                    || b.getBalance() != 200
                    || c.getBalance() != 300){
            System.out.println("a:" + a.getBalance());
            System.out.println("b:" + b.getBalance());
            System.out.println("c:" + c.getBalance());
            System.out.println("-----------");
        }

        }

    }

}
