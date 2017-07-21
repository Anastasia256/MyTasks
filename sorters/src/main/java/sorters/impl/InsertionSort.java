package sorters.impl;

import sorters.ArraySorter;
import sorters.Direction;

import java.util.Arrays;

public class InsertionSort implements ArraySorter{

    public Comparable[] sort(Comparable[] comp, Direction direction) {
        Comparable temp;
        int flag = direction == Direction.DESC ? -1 : 1;

        for (int i = comp.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (((comp[j].compareTo(comp[j + 1])) * flag) > 0) {
                    temp = comp[j];
                    comp[j] = comp[j + 1];
                    comp[j + 1] = temp;
                }
            }
        }
        return comp;
    }
}
