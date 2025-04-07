import java.util.Scanner;

public class WeightedQuickUnion {
    public static void main(String[] args) {
        // initialze UF class
        UnionFind uf = new UnionFind(10);

        // union some objects
        uf.union(3, 4);
        uf.union(4, 9);
        uf.union(2, 9);
        uf.union(6, 5);
        uf.union(3, 5);

        // check if p and q are connected or not

        Scanner getObjectScanner = new Scanner(System.in);
        System.out.print("Enter the value of p: ");
        int p = getObjectScanner.nextInt();
        System.out.print("Enter the value of q: ");
        int q = getObjectScanner.nextInt();

        if (uf.isConnected(p, q)) {
            System.out.printf("%d and %d are connected!", p, q);
        } else {
            System.out.printf("%d and %d are not connected!", p, q);
        }
        getObjectScanner.close();

    }
}

class QuickUnion {
    private int[] id;
    private int[] size;

    QuickUnion(int n) {
        id = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        int i = p;
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootq < rootp) {
            id[rootq] = rootp;
            size[rootp] += size[rootq];
        } else {
            id[rootp] = rootq;
            size[rootq] += size[rootp];
        }

        System.out.printf("%d   %d\n", p, q);

    }

}