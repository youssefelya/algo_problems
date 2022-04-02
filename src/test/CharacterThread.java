package test;

public class CharacterThread extends Thread {
    @Override
    public void run() {
        char c = 'a';
        while (true) {
            System.out.print(c);
            c++;
            if (c > 'z') c = 'a';
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
