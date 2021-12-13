import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainSolution {

    public static void main(String[] args) {
//[1,2,5]
        int[] arr = {1, 2, 5};

    }
    public int maxPower(String s) {
        int n = s.length();
        int max = -1, i=0;
        while(i<n){
            char c = s.charAt(i);
            int count=0;
            int j=i;
            while(j<n && c == s.charAt(j)){count++; j++;}
            max = Math.max(count,max);
            i=j;
        }
        return max;
    }
}
