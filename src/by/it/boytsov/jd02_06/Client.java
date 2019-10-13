package by.it.boytsov.jd02_06;

public class Client
{
    public static void main(String[] args)
    {
        for (int i = 1; i <= 5; i++)
        {
            Logger logger = Logger.getLogger();
            Thread thread = new Thread("Thread №" + i) {
                @Override
                public void run() {
                    System.out.println(this.getName() + " is running!");
                    try {
                        throw new Exceptions("Exception for logger from " + this.getName());
                    } catch (Exceptions e) {
                        logger.LogInfo(e.getMessage());
                    }
                }
            };
            thread.start();
        }
    }
}