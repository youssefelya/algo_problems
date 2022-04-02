package ioc;


public class UserService {

    MySQLDatabase<UserEntity> mySQLDatabase;

    public UserService() {
        // make connection with  database,
        // setting url, connection factory ....
        mySQLDatabase = new MySQLDatabase<>();
    }

    public UserEntity addUser(UserEntity userEntity) {
        mySQLDatabase.save(userEntity);
        return userEntity;
    }

    public UserEntity getUser(int id) {
        return mySQLDatabase.get(id);
    }


}
