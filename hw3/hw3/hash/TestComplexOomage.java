package hw3.hash;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestComplexOomage {

    @Test
    public void testHashCodeDeterministic() {
        ComplexOomage so = ComplexOomage.randomComplexOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    /* This should pass if your OomageTestUtility.haveNiceHashCodeSpread
       is correct. This is true even though our given ComplexOomage class
       has a flawed hashCode. */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(ComplexOomage.randomComplexOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /* TODO: Create a list of Complex Oomages called deadlyList
     * that shows the flaw in the hashCode function.
     */

    @Test
    public void testWithDeadlyParams() {
        List<Oomage> deadlyList = new ArrayList<>();

        // Your code here.
        for (int i = 0; i < 20; i++) {
            List<Integer> ina = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                int x = StdRandom.uniform(250,255);
                ina.add(x);
            }
            deadlyList.add(new ComplexOomage(ina));
        }
//        List<Integer> ina = new ArrayList<>();
//        ina.add(254);
//        ina.add(254);
//        ina.add(254);
//        ina.add(254);
//        ina.add(254);
//        ina.add(254);
//        deadlyList.add(new ComplexOomage(ina));
//        List<Integer> inb = new ArrayList<>();
//        inb.add(253);
//        inb.add(253);
//        inb.add(253);
//        inb.add(253);
//        inb.add(253);
//        inb.add(253);
//        deadlyList.add(new ComplexOomage(inb));
//        List<Integer> inc = new ArrayList<>();
//        inc.add(252);
//        inc.add(252);
//        inc.add(252);
//        inc.add(252);
//        inc.add(252);
//        inc.add(252);
//        deadlyList.add(new ComplexOomage(inc));
//        List<Integer> ind = new ArrayList<>();
//        ind.add(251);
//        ind.add(251);
//        ind.add(251);
//        ind.add(251);
//        ind.add(251);
//        ind.add(251);
//        deadlyList.add(new ComplexOomage(ind));
//        List<Integer> ine = new ArrayList<>();
//        ine.add(250);
//        ine.add(250);
//        ine.add(250);
//        ine.add(250);
//        ine.add(250);
//        ine.add(250);
//        deadlyList.add(new ComplexOomage(ine));
        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(deadlyList, 10));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestComplexOomage.class);
    }
}
