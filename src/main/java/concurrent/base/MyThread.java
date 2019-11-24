package concurrent.base;

import domain.User;
import lombok.Data;

@Data
public class MyThread extends Thread {

    private Long sleepTime;
    private User user;

    public MyThread(Long sleepTime, User user){
        this.sleepTime = sleepTime;
        this.user = user;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(this.sleepTime);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("in thread" + user.getUsername());
        user.setUsername("renew user");
        System.out.println("renew......");

    }
}
