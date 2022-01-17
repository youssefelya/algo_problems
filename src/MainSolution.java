

import java.util.*;

public class MainSolution {
    private List<Integer> list;

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};
        System.out.println(findReplaceString(s, indices, sources, targets));

    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), len = indices.length, i = 0, po = 0;
        Map<Integer, String[]> map = new HashMap<>();
        for (int q = 0; q < indices.length; q++) {
            map.put(indices[q], new String[]{sources[q], targets[q]});
        }
        StringBuilder str = new StringBuilder();
        while (po < n) {
            if (map.containsKey(po)) {
                int index = po;
                String gh = map.get(po)[0];
                if (index + gh.length() <= n && s.substring(index, index + gh.length()).equals(gh)) {
                    str.append(map.get(po)[1]);
                    i++;
                    po = index + gh.length();
                } else {
                    str.append(s.charAt(po));
                    po++;
                }

            } else {
                str.append(s.charAt(po));
                po++;
            }
        }
        return str.toString();
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length, i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int index = i + 1;
            while (index < n && end >= intervals[index][0]) index++;
            list.add(new int[]{start, intervals[index][1]});
            i = index;
        }
        int[][] answer = new int[list.size()][2];
        for (int x = 0; x < list.size(); x++) {
            answer[x][0] = list.get(x)[0];
            answer[x][1] = list.get(x)[1];
        }
        return answer;
    }


}
