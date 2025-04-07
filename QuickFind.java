import java.util.Scanner;

public class QuickFind {

    public static void main(String[] args) {
        // initialze UF class
        UnionFind uf = new UnionFind(10);

        // union some objects
        uf.union(0, 5);
        uf.union(5, 6);
        uf.union(1, 2);
        uf.union(2, 7);
        uf.union(3, 8);
        uf.union(3, 4);
        uf.union(4, 9);

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

class UnionFind {
    private int[] id;

    UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            this.id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p])
                id[i] = id[q];
        }

        System.out.printf("%d   %d\n", p, q);
    }

}