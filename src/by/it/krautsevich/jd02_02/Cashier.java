package by.it.krautsevich.jd02_02;

public class Cashier implements Runnable {

    private String name ;
    private boolean orderToStop = false ;

    public void setOrderToStop() {
        this.orderToStop = true;
    }

    public Cashier (int number) {
            name = "Cashier " + number ;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
        while ( Dispatcher.marketIsOpened() && (!orderToStop) )
        {try {

            Buyer buyer = QueueBuyers.extract() ;
            if (buyer != null)
            {System.out.println(this + " начал обслуживать " + buyer);
            int timeout = Rnd.fromTo(2000 , 5000) ;
            Thread.sleep(timeout);

                StringBuilder myString = new StringBuilder();
                myString.append("Чек ").append(buyer).append(":\n").append("-----------------------------\n");

                for ( String good : buyer.getMySet()) {
                    myString.append(good);
                    myString.append("-----");
                    myString.append(Market.listOfGoods.get(good)).append("\n") ;
                }
                myString.append("сумма покупки = ").append(buyer.getSum()).append(" рублей.");

                System.out.println(myString);

            System.out.println(this + " обслужил " + buyer);
            synchronized (buyer) {buyer.notify();}}
            if (buyer == null) {Thread.sleep(10);}
        }
        catch (InterruptedException e)
        {
            System.out.println("Проблемы у " + this);
        }}
        if (orderToStop) {
            System.out.println(this + " досрочно закрыл кассу!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Thread.interrupted();
        }
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString () {
        return name;
    }
}
