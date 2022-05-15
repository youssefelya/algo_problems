package jnjdPrep;

import java.io.*;
import java.util.Arrays;

public class GoogleMatrixTrace {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for (int test = 1; test <= testCase; test++) {
            String[] str = bf.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            String[] array = bf.readLine().split(" ");
            Arrays.sort(array);
            int count = 0;
            for (int r = 0; r < array.length; r++) {
                int v = Integer.parseInt(array[r]);
                if (B - v < 0) break;
                B = B - v;
                count++;
            }
            System.out.println("Case #" + test + ": " + count);
        }
    }

}

