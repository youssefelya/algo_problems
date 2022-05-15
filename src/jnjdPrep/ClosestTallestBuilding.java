package jnjdPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ClosestTallestBuilding {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for (int test = 1; test <= testCase; test++) {
            int N = Integer.parseInt(bf.readLine());
            String[] strs = bf.readLine().split(" ");
            int[] array = new int[N];
            for (int i = 0; i < N; i++)
                array[i] = Integer.parseInt(strs[i]);
            System.out.println(Arrays.toString(closestBuilding(N, array)));
        }
    }

    public static int[] closestBuilding(int n, int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] next = new int[array.length];
        int max = array[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > max) {
                stack.addFirst(i);
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peekLast()] <= array[i])
                stack.removeLast();
            if (stack.isEmpty())
                next[i] = -1;
            else
                next[i] = Math.abs(i - stack.peekLast())-1;
            stack.addLast(i);
        }
        return next;
    }
}
