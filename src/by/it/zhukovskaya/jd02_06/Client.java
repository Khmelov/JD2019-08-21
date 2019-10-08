package by.it.zhukovskaya.jd02_06;

public class Client {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Logger logger = Logger.getInstance();
            Thread thread = new Thread("Thread №" + i) {
                @Override
                public void run() {
                    System.out.println(this.getName() + " is running!");
                    try {
                        throw new MyException("Exception for logger from " + this.getName());
                    } catch (MyException e) {
                        logger.printErrorInfo(e.getMessage());
                    }
                }
            };
            thread.start();
        }
    }
}
