package concurrent.TransferAccount;

import concurrent.base.Account;

/**
 * 1.此时会有 a=100,b=100,c=300的情况
     * 是因为ab与bc同时进入transfer,此时都得到b=200,
     * 然后 bc执行，b=300,transfer方法结束，写入主内存b=300,
     * 然后ab执行，因为此时ab线程内存中的b=200，执行后b=100,
     * 然后transfer方法结束，写入主内存b=100
 *
 * 2.a=100,b=300,c=300
 *    同理可得
 */
public class MainTest {

    public static void main(String[] args) {

        while (true) {
            Account a = new Account();
            a.setBalance(200);

            Account b = new Account();
            b.setBalance(200);

            Account c = new Account();
            c.setBalance(200);


            TransferRunable transAB = new TransferRunable(a, b, 100);
            TransferRunable transBC = new TransferRunable(b, c, 100);

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
