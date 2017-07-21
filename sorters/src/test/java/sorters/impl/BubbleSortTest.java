package sorters.impl;

import objects.MyNumber;
import objects.MyWord;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sorters.ArraySorter;
import sorters.Direction;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {

    private ArraySorter testObject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testObject = new BubbleSort();
    }

    @Test
    public void testSortWordASC() {

        Comparable[] sourceWordArray = new MyWord[] {
                new MyWord("test"),
                new MyWord("TEST"),
                new MyWord("testtest"),
                new MyWord("teSt"),
                new MyWord("t_s_"),
        };

        Comparable[] expectedWordArray = new MyWord[] {
                new MyWord("TEST"),
                new MyWord("teSt"),
                new MyWord("test"),
                new MyWord("t_s_"),
                new MyWord("testtest"),
        };

        assertArrayEquals(expectedWordArray, testObject.sort(sourceWordArray, Direction.ASC));
    }

    @Test
    public void testSortWordDESC() {

        Comparable[] sourceWordArray = new MyWord[] {
                new MyWord("test"),
                new MyWord("TEST"),
                new MyWord("testtest"),
                new MyWord("teSt"),
                new MyWord("t_s_"),
        };

        Comparable[] expectedWordArray = new MyWord[] {
                new MyWord("testtest"),
                new MyWord("test"),
                new MyWord("t_s_"),
                new MyWord("teSt"),
                new MyWord("TEST"),
        };

        assertArrayEquals(expectedWordArray, testObject.sort(sourceWordArray, Direction.DESC));
    }
    @Test
    public void testSortNumberASK() {

        Comparable[] sourceNumberArray = new MyNumber[]{
                new MyNumber(4.0),
                new MyNumber(2.0),
                new MyNumber(3.0),
                new MyNumber(1.0),
                new MyNumber(-2.0),
        };

        Comparable[] expecteNumberdArray = new MyNumber[]{
                new MyNumber(-2.0),
                new MyNumber(1.0),
                new MyNumber(2.0),
                new MyNumber(3.0),
                new MyNumber(4.0)
        };

        assertArrayEquals(expecteNumberdArray, testObject.sort(sourceNumberArray, Direction.ASC));
    }

    @Test()
    public void testSortNumberDESC() {

        Comparable[] sourceNumberArray = new MyNumber[]{
                new MyNumber(4.0),
                new MyNumber(2.0),
                new MyNumber(3.0),
                new MyNumber(1.0),
                new MyNumber(-2.0),
        };

        Comparable[] expectedNumberArray = new MyNumber[]{
                new MyNumber(4.0),
                new MyNumber(3.0),
                new MyNumber(2.0),
                new MyNumber(1.0),
                new MyNumber(-2.0)
        };

        assertArrayEquals(expectedNumberArray, testObject.sort(sourceNumberArray, Direction.DESC));
    }

    @Test
    public void testSortExeptionCheck() {
        exception.expect(NullPointerException.class);

        testObject.sort(null, Direction.ASC);
    }

    @Test
    public void testCheckWordArrayHasNullElement() {
        Comparable[] sourceWordArray = new MyWord[] {
                new MyWord("testtest"),
                new MyWord("test"),
                new MyWord("t_s_"),
                null,
                new MyWord("TEST"),
        };

        assertThat(Arrays.asList(sourceWordArray).contains(null), is(true));
    }

    @Test
    public void testCheckNumberArrayHasNullElement() {

        Comparable[] sourceNumberArray = new MyNumber[]{
                new MyNumber(4.0),
                new MyNumber(2.0),
                new MyNumber(3.0),
                new MyNumber(1.0),
                null,
        };

        assertThat(Arrays.asList(sourceNumberArray).contains(null), is(true));
    }

    @Test
    public void testCheckWordArrayIsEmpty() {
        Comparable[] sourceWordArray = new MyWord[0];

        assertThat(Arrays.asList(sourceWordArray).isEmpty(), is(true));
    }


    @Test
    public void testCheckNumberArrayIsEmpty() {
        Comparable[] sourceNumberArray = new MyWord[0];

        assertThat(Arrays.asList(sourceNumberArray).isEmpty(), is(true));
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

}