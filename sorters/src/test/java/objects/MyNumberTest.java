package objects;

import org.junit.Test;
import sorters.Direction;

import static org.junit.Assert.*;

public class MyNumberTest {
    @Test
    public void compareToTest() throws Exception {
        MyNumber num1 = new MyNumber(1);
        MyNumber num2 = new MyNumber(1);
        MyNumber num3 = new MyNumber(5);



        assertEquals(0, num1.compareTo(num2));
        assertTrue(num1.compareTo(num3) < 0);
        assertFalse(num3.compareTo(num1) < 0);
    }

    @Test(expected = NullPointerException.class)
    public void testExeptionCheck() {
        MyNumber num1 = new MyNumber(7);
        MyNumber num2 = null;

        num1.compareTo(num2);
    }
}