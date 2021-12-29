
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws Exception {

    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int n = queries.length;
        Map<List<Integer>, int[]> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (r + 1 - l <= 1) {
                ans.add(true);
            } else {
                boolean p = canBePali(s, l, r + 1, queries[i][2], visited);
                visited.put(Arrays.asList(l, r + 1), new int[]{queries[i][2], p ? 1 : -1});
                ans.add(p);
            }

        }
        return ans;
    }

    private Boolean canBePali(String s, int left, int right, int k, Map<List<Integer>, int[]> visited) {
        if (visited.containsKey(Arrays.asList(right, left))) return visited.get(Arrays.asList(right, left))[1] == 1;
        while (left < right && k > 0) {
            if (s.charAt(right) != s.charAt(left)) k--;
            right--;
            left++;
            if (visited.containsKey(Arrays.asList(right, left)))
                return visited.get(Arrays.asList(right, left))[1] == 1 && visited.get(Arrays.asList(right, left))[0] >= k;
        }
        return left == k;
    }


}
