package task.manager;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class TaskManagerImplTest {

    private static TaskManager testObject;

    private LocalDateTime key1;
    private LocalDateTime key2;
    private LocalDateTime key3;
    private LocalDateTime key4;
    private LocalDateTime key5;
    private LocalDateTime key6;
    private LocalDateTime key7;


    private Task task1;
    private Task task2;
    private Task task3;
    private Task task4;
    private Task task5;
    private Task task6;
    private Task task7;

    private String[] existingCategories;
    private String[] nonExistentCategories;


    @BeforeClass
    public static void setUpClass() throws Exception {
        testObject = new TaskManagerImpl();
    }

    @Before
    public void setUp() throws Exception {

        key1 = LocalDateTime.of(2017, Month.JANUARY, 1, 1, 1);
        key2 = LocalDateTime.of(2017, Month.AUGUST, 11, 2, 2);
        key3 = LocalDateTime.of(2017, Month.OCTOBER, 3, 3, 3);
        key4 = LocalDateTime.of(2017, Month.AUGUST, 3, 3, 3);
        key5 = LocalDateTime.of(2017, Month.AUGUST, 11, 3, 3);
        key6 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        key7 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        task1 = new Task("testTask1", "testCategory1");
        task2 = new Task("testTask2", "testCategory1");
        task3 = new Task("testTask3", "testCategory1");
        task4 = new Task("testTask4", "testCategory4");
        task5 = new Task("testTask5", "testCategory5");
        task6 = new Task("testTask6", "testCategory6");
        task7 = new Task("testTask7", "testCategory7");

        existingCategories = new String[]{"testCategory1", "testCategory4", "testCategory5", "testCategory6", "testCategory7"};

        nonExistentCategories = new String[]{"testCategory2", "testCategory3"};

        testObject.add(key1, task1);
        testObject.add(key2, task2);
        testObject.add(key3, task3);
        testObject.add(key4, task4);
        testObject.add(key5, task5);
        testObject.add(key6, task6);
        testObject.add(key7, task7);
    }

    //@Ignore
    @Test
    public void testGetCategoriesMethod() {

        Set<String> actual = testObject.getCategories();

        Set<String> expected = new TreeSet<>();
        expected.add("testCategory1");
        expected.add("testCategory4");
        expected.add("testCategory5");
        expected.add("testCategory6");
        expected.add("testCategory7");

        assertThat(actual, is(expected));

        assertThat(actual, hasItems(existingCategories));

        assertThat(actual, not(hasItems(nonExistentCategories)));

        assertThat(actual, containsInAnyOrder(existingCategories));

        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(actual, hasSize(expected.size()));

    }

    //@Ignore
    @Test
    public void testGetTasksByCategoriesMethod() {

        Map<String, List<Task>> actual = testObject.getTasksByCategories(existingCategories);

        List<Task> expectedListForCategory1 = Arrays.asList(
                new Task("testTask1", "testCategory1"),
                new Task("testTask2", "testCategory1"),
                new Task("testTask3", "testCategory1"));

        List<Task> expectedListForCategory4 = Collections.singletonList(
                new Task("testTask4", "testCategory4"));

        List<Task> expectedListForCategory5 = Collections.singletonList(
                new Task("testTask5", "testCategory5"));

        List<Task> expectedListForCategory6 = Collections.singletonList(
                new Task("testTask6", "testCategory6"));

        List<Task> expectedListForCategory7 = Collections.singletonList(
                new Task("testTask7", "testCategory7"));

        Map<String, List<Task>> expected = new TreeMap<>();
        expected.put("testCategory1", expectedListForCategory1);
        expected.put("testCategory4", expectedListForCategory4);
        expected.put("testCategory5", expectedListForCategory5);
        expected.put("testCategory6", expectedListForCategory6);
        expected.put("testCategory7", expectedListForCategory7);

        assertThat(actual, is(expected));

        assertThat(actual, IsMapContaining.hasEntry("testCategory1", expectedListForCategory1));

        assertThat(actual, not(IsMapContaining.hasEntry("testCategory1", expectedListForCategory4)));

        assertThat(actual, IsMapContaining.hasKey("testCategory5"));

        assertThat(actual, not(IsMapContaining.hasKey("testCategory2")));

        assertThat(actual, IsMapContaining.hasValue(expectedListForCategory4));

        assertThat(actual.size(), is(expected.size()));

        assertFalse(actual.isEmpty());

        assertTrue(testObject.getTasksByCategories(nonExistentCategories).isEmpty());

    }

    @Test
    public void testGetTasksByCategoryMethod() {

        String existingCategory = "testCategory1";

        String nonExistentCategory = "testCategory2";

        List<Task> actual = testObject.getTasksByCategory(existingCategory);

        List<Task> expected = Arrays.asList(
                new Task("testTask1", "testCategory1"),
                new Task("testTask2", "testCategory1"),
                new Task("testTask3", "testCategory1")
        );

        assertThat(actual, is(expected));

        assertThat(actual, hasItems(
                new Task("testTask1", "testCategory1"),
                new Task("testTask2", "testCategory1"),
                new Task("testTask3", "testCategory1")));

        assertThat(actual.size(), is(expected.size()));

        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(testObject.getTasksByCategory(nonExistentCategory), IsEmptyCollection.empty());

    }

   // @Ignore
    @Test
    public void testGetTasksForTodayMethod() {

        List<Task> actual = testObject.getTasksForToday();

        List<Task> expected = Arrays.asList(
                new Task("testTask6", "testCategory6"),
                new Task("testTask7", "testCategory7")
        );

        assertThat(actual, is(expected));

        assertThat(expected, hasItems(
                new Task("testTask6", "testCategory6"),
                new Task("testTask7", "testCategory7")
        ));

        assertThat(actual.size(), is(expected.size()));

        assertThat(actual, not(IsEmptyCollection.empty()));

    }

    @After
    public void tearDown() throws Exception {
        key1 = null;
        key2 = null;
        key3 = null;
        key4 = null;
        key5 = null;

        task1 = null;
        task2 = null;
        task3 = null;
        task4 = null;
        task5 = null;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        testObject = null;
    }
}