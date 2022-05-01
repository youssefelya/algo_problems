
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    public static void main(String[] args) {
    }

    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        StringBuilder str_s = new StringBuilder();
        StringBuilder str_t = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (str_s.length() > 0) str_s.deleteCharAt(str_s.length() - 1);
            } else str_s.append(c);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (str_t.length() > 0) str_t.deleteCharAt(str_t.length() - 1);
            } else str_t.append(c);
        }
        return str_s.toString().equals(str_t.toString());
    }

}



