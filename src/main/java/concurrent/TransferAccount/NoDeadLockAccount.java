package concurrent.TransferAccount;

import lombok.Data;

@Data
public class NoDeadLockAccount {

    private Allocator allocator = Allocator.getInstance();
    private int balance;

    public void transfer(NoDeadLockAccount target, int money){

        // 申请锁
        while (!allocator.apply(this, target))
            ;
        try {
            Thread.sleep(10);
            synchronized (this) {
                Thread.sleep(10);
                synchronized (target) {
                    Thread.sleep(10);
                    if (this.balance > money) {
                        this.balance -= money;
                        target.balance += money;
                    }
                }
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            allocator.free(this, target);
        }
    }



}
