package ioc;

import java.util.List;
import java.util.UUID;

public class UserEntity {
    private String id;
    private String name;


    public UserEntity(String name) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
