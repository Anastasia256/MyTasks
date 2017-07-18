package objects;

public class MyNumber implements Comparable<MyNumber> {

    private final double number;

    public MyNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public int compareTo(MyNumber o) {
        if (getNumber() < o.getNumber()) return -1;
        if (getNumber() > o.getNumber()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
