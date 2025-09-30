package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimesTest {
    @Test
    public void testSquarePrimesSimple() {
        IntList L = IntList.of(2, 7, 9, 12, 13, 18);
        IntList expected = IntList.of(4, 49, 9, 12, 169, 18);
        boolean changed = IntListExercises.squarePrimes(L);
        assertEquals("4 -> 49 -> 9 -> 12 -> 169 -> 18", L.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExample() {
        IntList L = IntList.of(14, 15, 16, 17, 18);
        IntList expected = IntList.of(14, 15, 16, 289, 18);

        boolean changed = IntListExercises.squarePrimes(L);

        assertEquals(expected, L);
        assertTrue(changed);
    }
}
