package by.it.zlotnikova.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "--Cashier " + number;
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        System.out.println(this + " opens a cash-desk");
        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.extract();
            if (buyer != null) {
                System.out.println(this + " started service " + buyer.getBuyerName());
                // to do smth
                try {
                    Thread.sleep(Utils.random(2000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this + " ended service " + buyer.getBuyerName());
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                try {
                    Thread.sleep(1);  // change to producer-consumer model
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + " closes a cash-desk");
    }

    @Override
    public String toString() {
        return name;
    }
}
