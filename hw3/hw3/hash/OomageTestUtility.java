package hw3.hash;

import java.util.ArrayList;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        List<Oomage>[] buckets = new List[M];
        for (int i = 0; i < M; i++) {
            buckets[i] = new ArrayList();
        }
//        Wrong answer: use index rather than iterable.
//        for (List i:buckets){
//            i = new ArrayList();
//        }
        for (Oomage o:oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            buckets[bucketNum].add(o);
        }
        int min = oomages.size() / 50;
        int max = (int) (oomages.size() / 2.5);
        for (List i:buckets) {
            if (i.size() >= max || i.size() <= min) {
                return false;
            }
        }
        return true;
    }
}
