package strings;

public class StringTester {

    private long timer = 0;

    private void showTime(long timer) {
        System.out.println("method time: " + timer / 1000 / 3600 + ":" + timer / 1000 / 60 % 60 + ":" + timer / 1000 % 60 + ":" + timer % 1000);
    }

    public void testConcatString() {

        long startTime = System.currentTimeMillis();

        String startString = new String("Hello");
        String resultString = "";

        for (int i = 0; i < 100000; i++) {
            resultString = resultString.concat(startString);
        }
        timer = System.currentTimeMillis() - startTime;

        showTime(timer);
    }

    public void testConcatStringBuilder() {

        long startTime = System.currentTimeMillis();

        StringBuilder startString = new StringBuilder("Hello");
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            resultString = resultString.append(startString);
        }
        timer = System.currentTimeMillis() - startTime;

        showTime(timer);
    }

    public void testConcatStringBuffer() {

        long startTime = System.currentTimeMillis();

        StringBuffer startString = new StringBuffer("Hello");
        StringBuffer resultString = new StringBuffer();

        for (int i = 0; i < 100000; i++) {
            resultString = resultString.append(startString);
        }
        timer = System.currentTimeMillis() - startTime;

        showTime(timer);
    }
}
