package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static int[] sites;
    private WeightedQuickUnionUF groups;
    private int num;
    private int size;

    public Percolation(int N) {
        // create N-by-N grid, with all sites initially blocked
        if (N > 0) {
            num = N;
            sites = new int[N * N];
            groups = new WeightedQuickUnionUF(N * N);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sites[i * N + j] = 0;
                }
            }
        } else {
            throw new java.lang.IllegalArgumentException("Please input a positive N.");
        }


    }
    public void open(int row, int col) {
        // open the site (row, col) if it is not open already
        if (num == 1) {
            sites[0] = 1;
        }
        if (row >= 0 && col >= 0 && row < num && col < num) {
            if (!isOpen(row, col)) {
                int middle = row * num + col;
                sites[middle] = 1;
                int[] neighbor;
                if (middle == 0) {
                    neighbor = new int[]{middle + 1, middle + num};
                } else if (middle == num - 1) {
                    neighbor = new int[]{middle - 1, middle + num};
                } else if (middle == num * (num - 1)) {
                    neighbor = new int[]{middle + 1, middle - num};
                } else if (middle == num * num - 1) {
                    neighbor = new int[]{middle - 1, middle - num};
                } else if (col == 0) {
                    neighbor = new int[]{middle + 1, middle - num, middle + num};
                } else if (col == num - 1) {
                    neighbor = new int[]{middle - 1, middle - num, middle + num};
                } else if (row == 0) {
                    neighbor = new int[]{middle - 1, middle + 1, middle + num};
                } else if (row == num - 1) {
                    neighbor = new int[]{middle - 1, middle + 1, middle - num};
                } else {
                    neighbor = new int[]{middle - 1, middle + 1, middle - num, middle + num};
                }

                for (int w: neighbor) {
                    if (isOpen(w / num, w % num)) {
                        groups.union(middle, w);
                    }
                }
                size += 1;
            }
        } else {
            throw new java.lang.IndexOutOfBoundsException("Please input valid row or/and col.");
        }
    }

    public boolean isOpen(int row, int col) {
        // is the site (row, col) open?
        if (row >= 0 && col >= 0 && row < num && col < num) {
            return sites[row * num + col] == 1;
        } else {
            throw new java.lang.IndexOutOfBoundsException("Please input valid row or/and col.");
        }

    }
    public boolean isFull(int row, int col) {
        // is the site (row, col) full?
        if (row >= 0 && col >= 0 && row < num && col < num) {
            if (!isOpen(row, col)) {
                return false;
            }
            for (int i = 0; i < num; i++) {
                if (isOpen(0, i)) {
                    if (groups.connected(i, row * num + col)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            throw new java.lang.IndexOutOfBoundsException("Please input valid row or/and col.");
        }

    }
    public int numberOfOpenSites() {
        return size;
    }

    public boolean percolates() {
        // does the system percolate?
        if (num == 1 && isOpen(0, 0)) {
            return true;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (groups.connected(num * (num - 1) + i, j) && num != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // use for unit testing (not required)

        //test1
//        Percolation a = new Percolation(5);
//        a.open(1, 1);
//        a.open(1, 0);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.println(a.sites[i * a.num + j]);
//            }
//        }
//        System.out.println(a.groups.connected(2, 3));
//        System.out.println(a.groups.connected(0, 2));
//        System.out.println(a.percolates());
//        a.open(0, 0);
//        System.out.println(a.percolates());

        //test2
//        Percolation a = new Percolation(1);
//        System.out.println(a.percolates());
//        a.open(0, 0);
//        System.out.println(a.percolates());

        //test3
        Percolation a = new Percolation(2);
        a.open(0, 0);
        a.open(0, 1);
        System.out.println(a.percolates());
        a.open(1, 1);
        System.out.println(a.percolates());

    }
}
