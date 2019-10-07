package by.it.rojas.jd18;

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

                StringBuilder myString = new StringBuilder();
                myString.append("Чек ").append(buyer).append(":\n");
                String delimeter = "";
                for ( String good : buyer.getMySet()) {
                    myString.append(delimeter) ;
                    myString.append(good);
                    myString.append("-----");
                    myString.append(Runner.listOfGoods.get(good)) ;
                    delimeter = "\n" ;
                }
                myString.append("\nсумма покупки = ").append(buyer.getSum()).append("рублей.");

                System.out.println(myString);

                System.out.println(this + " обслужил " + buyer);
                synchronized (buyer) {
                    buyer.setIWait(false);
                    buyer.notifyAll();}}
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
