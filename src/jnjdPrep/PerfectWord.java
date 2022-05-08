package jnjdPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String subString = "111";
        String word = bf.readLine();
        System.out.println((N - word.replace(subString, "").length()) / 3);
    }
}
