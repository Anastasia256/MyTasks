package objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyNumberTest {
    @Test
    public void compareToTest() throws Exception {
        MyNumber myNumber1 = new MyNumber(1);
        MyNumber myNumber2 = new MyNumber(1);

        assertEquals(0, myNumber1.compareTo(myNumber2));
    }
}