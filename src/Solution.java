


import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    static List<String> list = new ArrayList<>();
    static Vector<String> vector = new Vector<>();

    static class Threading extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                list.add(Thread.currentThread().getName() + "_" );
                vector.add(Thread.currentThread().getName() + "_" );
                System.out.print(i + " ");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Threading tr = new Threading();
        Threading tr2 = new Threading();
        tr.start();
        tr2.start();

        Thread.sleep(3000);
        System.out.println();
        System.out.println("list : "+list);
        System.out.println("vector : " + vector);
    }


}
