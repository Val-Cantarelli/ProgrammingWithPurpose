import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivationFunctionTest {
    @Test
    public void signTest() {
        assertEquals(1, ActivationFunction.softsign(Double.POSITIVE_INFINITY), 0.000000001);
    }

    @Test
    public void heavisideTest() {
        assertEquals(0.0, ActivationFunction.heaviside(Double.NEGATIVE_INFINITY), 0.000001);
    }

    @Test
    public void sqnlTest() {
        assertEquals(-1.0, ActivationFunction.sqnl(-Double.MAX_VALUE), 0.000001);
        assertEquals(1.0, ActivationFunction.sqnl(Double.MAX_VALUE), 0.000001);
        assertEquals(-1.0, ActivationFunction.sqnl(Double.NEGATIVE_INFINITY), 0.000001);
        assertEquals(1.0, ActivationFunction.sqnl(Double.POSITIVE_INFINITY), 0.000001);
    }

    @Test
    public void tanhTest() {
        assertEquals(-1.0, ActivationFunction.tanh(-Double.MAX_VALUE), 0.000001);
        assertEquals(1.0, ActivationFunction.tanh(Double.MAX_VALUE), 0.000001);
        assertEquals(-1.0, ActivationFunction.tanh(Double.NEGATIVE_INFINITY), 0.000001);
        assertEquals(1.0, ActivationFunction.tanh(Double.POSITIVE_INFINITY), 0.000001);
    }


}
