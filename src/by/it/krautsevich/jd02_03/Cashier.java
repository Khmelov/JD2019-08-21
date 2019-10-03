package by.it.krautsevich.jd02_03;

public class Cashier implements Runnable {

    private String name ;

    public Cashier (int number) {
            name = "Cashier " + number ;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
        while (Dispatcher.marketIsOpened())
        {try {
            Buyer buyer = QueueBuyers.extract() ;
            if (buyer != null)
            {System.out.println(this + " начал обслуживать " + buyer);
            int timeout = Rnd.fromTo(2000 , 5000) ;
            Thread.sleep(timeout);
            System.out.println(this + " обслужил " + buyer);
            synchronized (buyer) {buyer.notify();}}
            if (buyer == null) {Thread.sleep(10);}

        }
        catch (InterruptedException e)
        {
            System.out.println("Проблемы у " + this);
        }}
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString () {
        return name;
    }
}
