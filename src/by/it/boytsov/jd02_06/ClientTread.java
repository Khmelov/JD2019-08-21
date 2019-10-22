package by.it.boytsov.jd02_06;


public class ClientTread extends Thread{
    ClientTread(String name) {
        this.setName(name);
    }

    @Override
    public void run()
    {
        Logger logger = Logger.getLogger();
        logger.LogInfo("I am "+this.getName());
    }
}
