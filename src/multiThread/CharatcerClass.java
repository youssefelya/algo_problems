package multiThread;

public class CharatcerClass implements Runnable {
    @Override
    public void run() {
        char c = 'a';
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(c + " ");
            c++;
            if (c >= 'z') c = 'a';
        }
    }
}
