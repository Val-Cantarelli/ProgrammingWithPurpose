import junit.framework.TestCase;
import org.junit.Test;

public class FistLCTest extends TestCase {
    @Test
    public void test() {
        int[] value = {8, 8, 8, 16, 16, 16};
        assertEquals(3, FistLC.countCompleteDayPairs(value));
        assertEquals(2, FistLC.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        assertEquals(2, FistLC.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24, 3}));


    }
}