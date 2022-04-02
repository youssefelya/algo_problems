package multiThread;

public class DigintClass implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + " ");
            i++;
            if (i >= 10) i = 0;
        }
    }
}
