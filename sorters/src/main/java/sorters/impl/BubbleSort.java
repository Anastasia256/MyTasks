package sorters.impl;

import sorters.ArraySorter;
import sorters.Direction;

public class BubbleSort implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] comp, Direction direction) {

        boolean swapped;
        Comparable temp;

        do {
            swapped = false;
            for (int i = 1; i < comp.length; i++) {
                if (comp[i-1].compareTo(comp[i]) > 0 & direction == Direction.ASC || comp[i-1].compareTo(comp[i]) < 0 & direction == Direction.DESC) {
                    temp = comp[i-1];
                    comp[i-1] = comp[i];
                    comp[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        return comp;
    }
}
