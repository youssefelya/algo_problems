
public class MainSolution {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            new Multithreading().start();
        }
    }
    static class Multithreading extends Thread {
        public void run() {
            System.out.println(this.getId());
        }
    }
}



