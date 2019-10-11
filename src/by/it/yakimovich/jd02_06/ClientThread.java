package by.it.yakimovich.jd02_06;

public class ClientThread  extends Thread{


    public ClientThread(String name) {
        super (name);
    }

    @Override
    public void run(){
        Logger logger = Logger.getLogger ();
        logger.log ("I am "+this.getName ());

    }


}
