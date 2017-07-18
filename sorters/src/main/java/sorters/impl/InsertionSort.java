package sorters.impl;

import sorters.ArraySorter;
import sorters.Direction;

public class InsertionSort implements ArraySorter{

    @Override
    public Comparable[] sort(Comparable[] comp, Direction direction) {

        Comparable temp;

        for (int i = 1; i < comp.length; i++) {
            for (int j = i; j > 0 && comp[j-1].compareTo(comp[j]) > 0 && direction == Direction.ASC || comp[j-1].compareTo(comp[j]) < 0 && direction == Direction.DESC; j--){
                temp = comp[j-1];
                comp[j-1] = comp[j];
                comp[j] = temp;
            };
        }

        return comp;
    }
}
