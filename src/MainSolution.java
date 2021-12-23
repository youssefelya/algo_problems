
import java.util.*;

public class MainSolution {


    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(s1);
    }

    //https://leetcode.com/problems/word-search-ii/submissions/
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();
        Map<Character, List<List<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                graph.computeIfAbsent(board[i][j], x -> new ArrayList<>());
                graph.get(board[i][j]).add(Arrays.asList(i, j));
            }
        }
        for (String word : words) {
            if (graph.containsKey(word.charAt(0))) {
                for (List<Integer> neighbor : graph.get(word.charAt(0)))
                    if (bfs(word, 0, board, neighbor.get(0), neighbor.get(1))) {
                        answer.add(word);
                        break;
                    }
            }
        }
        return answer;
    }

    private boolean bfs(String word, int index, char[][] board, int i, int j) {
        if (index >= word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || word.charAt(index) != board[i][j])
            return false;
        char t = board[i][j];
        board[i][j] = '#';
        boolean result = bfs(word, index + 1, board, i + 1, j) ||
                bfs(word, index + 1, board, i - 1, j) ||
                bfs(word, index + 1, board, i, j + 1) ||
                bfs(word, index + 1, board, i, j - 1);
        board[i][j] = t;
        return result;
    }


}
