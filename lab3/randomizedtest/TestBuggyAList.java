package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        correct.addLast(4);correct.addLast(3);correct.addLast(5);
        buggy.addLast(4);buggy.addLast(3);buggy.addLast(5);
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeBuggyL = buggyL.size();
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0 && buggyL.size() > 0) {
                    L.getLast();
                    buggyL.getLast();
                }
            } else if (operationNumber == 3) {
                //removeLast
                if (L.size() > 0 && buggyL.size() > 0) {
                    int x = L.removeLast();
                    int y = buggyL.removeLast();
                }
            }
        }
    }
}
