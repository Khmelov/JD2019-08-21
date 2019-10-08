package by.it.liukhtenko.jd02_06;

public class Client {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("I main thread");

            for (int i = 0; i < 5; i++) {
               new ClientThread("th" + i).start();
        }
    }
}
