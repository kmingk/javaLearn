package concurrent.base;

import lombok.Data;

@Data
public class Account {

    private int balance;

    public synchronized void transfer(Account target, int money){
        try {
            Thread.sleep(10);
            if (this.balance > money) {
                this.balance -= money;
              //  Thread.sleep(10);
                target.balance += money;
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

}
