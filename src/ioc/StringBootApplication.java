package ioc;

public class StringBootApplication {

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserEntity userEntity = new UserEntity("abc");
        UserEntity userEntity2 = new UserEntity("efg");
        userService.addUser(userEntity);
        userService.addUser(userEntity2);


    }

}
