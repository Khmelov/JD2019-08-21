package by.it.yuntsevich.jd02_06;

public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger logger = Logger.getLogger();
        logger.toLog("I am "+this.getName());
    }
}
