package domain;

import lombok.Data;

@Data
public class User {

    private String username;
    private int age;

    public void close(){
        System.out.println("User close");
    }

    public static void main(String[] args) {
        User user = new User();
        user.username = "name";
        System.out.println(user.toString());
    }


}
