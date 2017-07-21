package objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyWordTest {

    @Test
    public void testComparetoMyWord() {
        MyWord word1 = new MyWord("test");
        MyWord word2 = new MyWord("test");
        MyWord word3 = new MyWord("t_s_");
        MyWord word4 = null;
        MyWord word5 = new MyWord("");
        MyWord word6 = new MyWord("TEST");

        int excpectedRight = 0;

        assertEquals(excpectedRight, word1.compareTo(word2));
        assertEquals(excpectedRight, word1.compareTo(word3));

        assertTrue(word1.compareTo(word6) > 0);
        assertTrue(word6.compareTo(word1) < 0);
        assertTrue(word1.compareTo(word5) > 0);

        assertNull(word4);
        assertNotNull(word5);
    }

    @Test(expected = NullPointerException.class)
    public void testCompareToExept() {
        MyWord word1 = new MyWord("test");
        MyWord word2 = null;

        word1.compareTo(word2);
    }

}