package by.it.boytsov.jd02_06;


public class Client
{
    public static void main(String[] args)
    {
        Logger logger= Logger.getLogger();
        logger.LogInfo("Main thread");
        for (int i = 0; i < 5 ; i++)
            new ClientTread("thread " + i).start();
    }
}