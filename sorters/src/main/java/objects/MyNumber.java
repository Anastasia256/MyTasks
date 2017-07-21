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
        return Double.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyNumber myNumber = (MyNumber) o;

        return Double.compare(myNumber.number, number) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(number);
        return (int) (temp ^ (temp >>> 32));
    }
}
