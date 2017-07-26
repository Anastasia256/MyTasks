package task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) {

        ArrayList<String> stringList = new ArrayList<String>() {{
            add("C");
            add("I");
            add("G");
            add("H");
            add("D");
            add("F");
            add("A");
            add("L");
            add("K");
            add("J");
            add("B");
            add("M");
            add("E");
        }} ;

        luckySort(stringList, new StringComparator());
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {

        Collections.sort(strings, comp);

        for (int i = 0; i < strings.size() - 1; i++) {
            while (strings.get(i).compareTo(strings.get(i + 1)) < 0) {
                Collections.shuffle(strings);
            }
        }
        System.out.println(strings);
    }
}
