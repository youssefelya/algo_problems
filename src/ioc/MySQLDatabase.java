package ioc;

import java.util.ArrayList;
import java.util.List;

public class MySQLDatabase<T> {

    List<T> sqlSchema;

    public MySQLDatabase() {
        sqlSchema = new ArrayList<>();
    }

    public void save(T object) {
        System.out.println("Save successfully " + String.valueOf(object));
        sqlSchema.add(object);
    }

    public T get(int id) {
        System.out.println("Get successfully ");
        if (id < sqlSchema.size()) sqlSchema.get(id);
        return null;
    }

}
