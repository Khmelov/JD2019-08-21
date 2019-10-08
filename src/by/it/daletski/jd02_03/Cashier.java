package by.it.daletski.jd02_03;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        name = "--Cashier " + number;
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        System.out.println(this +" OPENED");
        while (Dispatcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " start service " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " stop service " + buyer);
                synchronized (buyer) {
                    buyer.resetWaiting();
                    buyer.notifyAll();
                }
            }
            else {
                Util.sleep(1); //bad solution
            }
        }
        System.out.println(this +" CLOSED");
    }

    @Override
    public String toString() {
        return name;
    }
}
