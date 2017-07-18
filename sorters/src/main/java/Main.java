import objects.MyNumber;
import objects.MyWord;
import sorters.ArraySorter;
import sorters.Direction;
import sorters.impl.BubbleSort;
import sorters.impl.InsertionSort;
import sorters.impl.SelectionSort;

import static sorters.Direction.ASC;
import static sorters.Direction.DESC;

public class Main {
    public static void main(String[] args) {
        /*
        * 1. вывести массив до сортировки
        * и после всех типов сортировки в режиме ASK
        * */
        MyNumber[] numbers = new MyNumber[5];
        numbers[0] = new MyNumber(5);
        numbers[1] = new MyNumber(23);
        numbers[2] = new MyNumber(2);
        numbers[3] = new MyNumber(-12);
        numbers[4] = new MyNumber(2);

        /*
        * 2. вывести массив до сортировки
        * и после всех типов сортировки в режиме DESC
        * */
        MyWord[] words = new MyWord[5];
        words[0] = new MyWord("aaaaaaaaa");
        words[1] = new MyWord("aaaaaaaaaaaa");
        words[2] = new MyWord("cccccccccc");
        words[3] = new MyWord("bbbbbbbbbbbb");
        words[4] = new MyWord("xxxxxxxxxx");

        ArraySorter bubbleSort = new BubbleSort();

        ArraySorter insertionSort = new InsertionSort();

        ArraySorter selectionSort = new SelectionSort();

        showSortResult(bubbleSort, numbers, ASC);
        showSortResult(insertionSort, numbers, ASC);
        showSortResult(selectionSort, numbers, ASC);

        showSortResult(bubbleSort, words, DESC);
        showSortResult(insertionSort, words, DESC);
        showSortResult(selectionSort, words, DESC);
    }

    public static void showSortResult(ArraySorter obj, Comparable[] arr, Direction d) {
        obj.sort(arr, d);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
