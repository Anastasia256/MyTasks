package sorters.impl;

import sorters.ArraySorter;
import sorters.Direction;

public class SelectionSort implements ArraySorter {

    @Override
    public Comparable[] sort(Comparable[] comp, Direction direction) {

        for (int i = 0; i < comp.length; i++) {

            int min_i = i;
            Comparable temp;

            for (int j = i + 1; j < comp.length; j++) {

                if (comp[j].compareTo(comp[i]) < 0 & direction == Direction.ASC || comp[j].compareTo(comp[i]) > 0 & direction == Direction.DESC) {
                    temp = comp[j];
                    comp[j] = comp[i];
                    comp[i] = temp;
                }
            }
        }

        return comp;
    }
}
