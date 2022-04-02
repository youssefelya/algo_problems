package multiThread;

public class FooClass implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Foo ");
    }
}
