package by.it.rojas.jd16;

public class Cashier implements Runnable {
    private String name;

    Cashier(int number) {
        name = ":=) Cashier " + number;
    }

    @Override
    public void run() {
        System.out.println(this + " OPENED CASH DESK");
        while (Dispatcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " started serving " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " finished serving " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            else {
                Util.sleep(1);
            }
        }
        System.out.println(this+" CLOSED CASH DESK");
    }

    @Override
    public String toString() {
        return name;
    }
}
