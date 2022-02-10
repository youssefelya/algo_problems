import java.util.Date;

public class Singleton {

    // ....
    private static Singleton instance;

    private Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
