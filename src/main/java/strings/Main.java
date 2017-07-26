package strings;

public class Main {
    public static void main(String[] args) {

        StringTester test = new StringTester();

        test.testConcatString();

        test.testConcatStringBuilder();

        test.testConcatStringBuffer();

//        long time = 203350;
//        System.out.println("method time: " + time / 1000 / 3600 + ":" + time / 1000 / 60 % 60 + ":" + time / 1000 % 60 + ":" + time % 1000);

    }
}
