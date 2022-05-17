import data_struct.TreeNode;

import java.util.*;

class Child {
    {
        System.out.println("Child class init block 1");
    }

    static {
        System.out.println("Child class  static init 2");
    }
}

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> list = new ArrayList<>();
        vector.add(1);

        System.out.println(map.get(1));
        int[][] A = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
    }

    public final TreeNode getTargetCopy(final TreeNode original,
                                        final TreeNode cloned,
                                        final TreeNode target) {

        if (original == null || target == null) return null;
        TreeNode temporary = null;
        if (original.val == target.val) return cloned;
        temporary = getTargetCopy(original.left, cloned.left, target);
        if(temporary != null)return temporary;
        temporary = getTargetCopy(original.right, cloned.right, target);
        return temporary;
    }
}








