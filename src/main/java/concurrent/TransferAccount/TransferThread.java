package concurrent.TransferAccount;

import concurrent.base.Account;

import java.util.Random;

public class TransferThread extends Thread {

    private Account self;
    private Account target;
    private int money;

    private final Random random = new Random(10);

    public TransferThread(Account self, Account target, int money){
        super("aa" + self);
        this.self = self;
        this.target = target;
        this.money = money;
    }

    @Override
    public void run() {

        self.transfer(this.target, this.money);

    }

}
