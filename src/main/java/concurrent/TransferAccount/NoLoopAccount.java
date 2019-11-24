package concurrent.TransferAccount;

import lombok.Data;

@Data
public class NoLoopAccount {

    private int id;
    private int balance;

    public NoLoopAccount(int id){
        this.id = id;
    }

    public void transfer(NoLoopAccount target, int money){

        NoLoopAccount left = this;
        NoLoopAccount right = target;

        if(left.getId() > target.getId()){
            left = target;
            right = this;
        }

        try {
            Thread.sleep(10);
            synchronized (left) {
                Thread.sleep(10);
                synchronized (right) {
                    Thread.sleep(10);
                    if (this.balance > money) {
                        this.balance -= money;
                        target.balance += money;
                    }
                }
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }



}
