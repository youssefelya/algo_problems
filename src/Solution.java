
public class Solution {

//https://leetcode.com/problems/random-pick-with-weight/submissions/
    public static void main(String[] args) {

    }

    int[] w_sum;
    public Solution(int[] w) {
        w_sum = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            w_sum[i] = sum;
        }
    }

    public int pickIndex() {
        double target = w_sum[w_sum.length - 1] * Math.random();
        for(int i = 0; i < w_sum.length; i++){
            if(target < w_sum[i]) return i;
        }
        return -1;
    }

}
