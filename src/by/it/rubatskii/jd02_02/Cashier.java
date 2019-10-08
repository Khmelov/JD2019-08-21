package by.it.rubatskii.jd02_02;

public class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        Dispatcher.cashierList.add(this);
        System.out.println(this + "started Cashier ");

        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.callFromQueue();
            if (buyer != null) {
                System.out.println(this + " started to work " + buyer);
                int serviceTime = Util.randomFromTo(2000, 5000);
                try {
                    Util.sleepAccelerated(serviceTime);
                } catch (InterruptedException e) {
                    System.out.println(this + ": exception run()!");
                }
                System.out.println(buyer + " buy " + buyer.getBasket());
                System.out.println(this + " finished serving " + buyer);
                synchronized (buyer) {
                    buyer.notifyAll();
                }
            } else {
                synchronized (this) {
                    try {
                        this.wait(1000 / Dispatcher.timeFactor);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        System.out.println(this + " finished work");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
