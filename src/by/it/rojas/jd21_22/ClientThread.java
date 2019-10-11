package by.it.rojas.jd21_22;

public class ClientThread extends Thread{

    ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
            Logger logger = Logger.getLogger();
            logger.log("I am " + this.getName());
    }
}
