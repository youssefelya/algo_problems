package jnjdPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] matrix = new int[N][N];
        int trace = 0, row = 0, col = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean currentRow = true;
            String s = bf.readLine();
            String[] res = s.split(" ");
            for (int j = 0; j < N; j++) {
                int Mij = Integer.parseInt(res[j]);
                matrix[i][j] = Mij;
                if (i == j) {
                    trace += Mij;
                }
                if (set.contains(Mij) && currentRow) {
                    row++;
                    currentRow = false;
                } else {
                    set.add(Mij);
                }
            }
        }
        col = repeatedColum(matrix, N);
        System.out.println(trace + " " + row + " " + col);

    }

    private static int repeatedColum(int[][] matrix, int N) {
        int co = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                int k = matrix[j][i];
                if (set.contains(k)) {
                    co++;
                    break;
                } else {
                    set.add(k);
                }
            }
        }
        return co;
    }
}
