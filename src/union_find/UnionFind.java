package union_find;

import java.io.*;

public class UnionFind {

    int N;

    public UnionFind(int n) {
        this.N = n;
    }


    public UnionFind(int n, File file) throws FileNotFoundException {
        this.N = n;
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    }


}
