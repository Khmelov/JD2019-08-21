package by.it.rubatskii.jd02_02;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        name = "Cashier " + number;
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        while (Dispatcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            System.out.println(this+" start service "+buyer);
            int timeout = Util.random(2000, 5000);
            Util.sleep(timeout);
            System.out.println(this+" stop service "+buyer);
            synchronized (buyer) {
                buyer.notify();
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
