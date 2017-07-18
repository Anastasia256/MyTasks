package objects;

public class MyWord implements Comparable<MyWord> {

    private final String word;

    public MyWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(MyWord o) {
        String s1 = getWord();

        String s2 = o.getWord();

        char[] str1 = s1.toCharArray();

        char[] str2 = s2.toCharArray();

        int length = Math.min(s1.length(), s2.length());

        int k = 0;

        while (k < length-1) {
            char ch1 = str1[k];
            char ch2 = str2[k];

            if (ch1 != ch2) {
                return ch1 - ch2;
            }
            k+=2;
        }
        return s1.length() - s2.length();
    }

    @Override
    public String toString() {
        return "" + word;
    }
}
