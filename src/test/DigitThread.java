package test;

public class DigitThread extends Thread {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.print(count);
            count++;
            if (count == 10) count = 0;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
