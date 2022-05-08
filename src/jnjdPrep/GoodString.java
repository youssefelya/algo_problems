package jnjdPrep;

import java.io.*;

public class GoodString {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= testCase; t++) {
            String[] strs = bf.readLine().split(" ");
            int N = Integer.parseInt(strs[0]);
            int K = Integer.parseInt(strs[1]);
            String S = bf.readLine();
            int count = 0;
            int i = 0;
            while (i < N) {
                if (S.charAt(i) == S.charAt(N - 1 - i)) {
                    K--;
                    if (K < 0) count++;
                }
                i++;
            }
            System.out.println("Case #" + t + ": " + count);
        }

    }

}

