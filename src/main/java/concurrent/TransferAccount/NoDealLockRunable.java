package concurrent.TransferAccount;

import concurrent.base.Account;

import java.util.Random;

public class NoDealLockRunable implements Runnable {

    private NoDeadLockAccount self;
    private NoDeadLockAccount target;
    private int money;

    private final Random random = new Random(10);

    public NoDealLockRunable(NoDeadLockAccount self, NoDeadLockAccount target, int money){
        this.self = self;
        this.target = target;
        this.money = money;
    }

    @Override
    public void run() {

        self.transfer(this.target, this.money);

    }

}
