public class Singleton {

    private String getHelper() {
        return "Hello";
    }

    // ....
    private static Singleton instance;

    public Singleton(){}

    public static int findDuplicate(){
        return Integer.MAX_VALUE;
    }
    private static class SingletonHolder { public static final Singleton INSTANCE = new Singleton();}

    public static Singleton getInstance() {




        int v = findDuplicate();
        return SingletonHolder.INSTANCE;
    }
}
