package by.it.akhrem.jd02_06;

public class TestLogger {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
           new TsThread(i).start();
        }
    }
}
