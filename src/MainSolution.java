

import java.util.*;

public class MainSolution {
    private List<Integer> list;

    public static void main(String[] args) {
        String s = "annabelle";
        System.out.println(canConstruct(s, 2));
    }

    public static boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k >= n) return k == n;
        int[] array = new int[28];
        for (int i = 0; i < n; i++)
            array[s.charAt(i) - 'a']++;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 28; i++)
            if (array[i] > 0) {
                map.put(array[i], map.getOrDefault(array[i], 0) + array[i]);
            }
        return canConstructHelper(map, k);
    }

    private static boolean canConstructHelper(Map<Integer, Integer> map, int k) {
        if (!map.containsKey(1)) return true;
        if (map.get(1) > map.size() - 1) return false;
        while (k > 0 && map.containsKey(1)) {
            for (int i = 2; i < 28; i = i + 2) {
                if (map.containsKey(i)) {
                    if (map.get(i) == 1)
                        map.remove(i);
                    else map.put(i, map.get(i) - 1);
                    map.put(1, map.get(1) - 1);
                    k--;
                    break;
                }
            }
        }
        return k == 0 && !map.containsKey(1);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        int n = pattern.length();
        if (array.length != n) return false;
        Map<Character, String> cache_chars = new HashMap<>();
        Map<String, Character> cache_word = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (cache_chars.containsKey(pattern.charAt(i))) {
                if (!cache_chars.get(pattern.charAt(i)).equals(array[i])) return false;
            } else
                cache_chars.put(pattern.charAt(i), array[i]);

            if (cache_word.containsKey(array[i])) {
                if (cache_word.get(array[i]) != pattern.charAt(i)) return false;
            } else cache_word.put(array[i], pattern.charAt(i));

        }
        return true;
    }


    public int minMoves(int target, int maxDoubles) {
        return minMovesHelper(maxDoubles, target, new HashMap<>());
    }

    private int minMovesHelper(int maxDoubles, int target, HashMap<String, Integer> visited) {
        if (1 == target) return 0;
        if (target < 1) return 99999 * 99;
        if (visited.containsKey(maxDoubles + "#" + target))
            return visited.get(maxDoubles + "#" + target);
        int v1 = 9999 * 9;
        if (maxDoubles > 0)
            v1 = minMovesHelper(maxDoubles - 1, target / 2, visited);
        int v2 = minMovesHelper(maxDoubles, target - 1, visited);
        visited.put(maxDoubles + "#" + target, 1 + Math.min(v1, v2));
        return visited.get(maxDoubles + "#" + target);
    }


    public static String[] divideString(String s, int k, char fill) {
        int n = s.length(), i = 0;
        List<String> list = new ArrayList<>();

        int v = k;
        while (i < n) {
            StringBuilder str = new StringBuilder();
            v = k;
            while (v > 0 && i < n) {
                str.append(s.charAt(i));
                i++;
                v--;
            }
            while (v > 0) {
                str.append(fill);
                v--;
            }
            list.add(str.toString());
        }
        return list.toArray(list.toArray(new String[0]));
    }

}
