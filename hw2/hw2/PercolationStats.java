package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int[] x;
    private int total;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        // perform T independent experiments on an N-by-N grid
        x = new int[T];
        total = T;
        while (T > 0) {
            Percolation sample = pf.make(N);
            while (!sample.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                sample.open(row, col);
            }
            x[T - 1] = sample.numberOfOpenSites();
            T += -1;
        }
    }
    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(x);
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(x);
    }
    public double confidenceLow() {
        // low endpoint of 95% confidence interval
        double low = mean() - 1.96 * stddev() / Math.sqrt(total);
        return low;
    }
    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        double high = mean() + 1.96 * stddev() / Math.sqrt(total);
        return high;
    }
}
