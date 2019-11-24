package lombok;

import domain.User;

public class MainTest {

    public static void main(String[] args) {

        // var --> final
        val  a = "aa";
        //a= a +"aa";
        System.out.println(a);

        play("a");

        // @Cleanup --> 相当于加了在finally中执行close()方法
        try{
            @Cleanup  User user = new User();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    // 非空检查
    public static void play(@NonNull String str){
        System.out.println(str);
    }

}
