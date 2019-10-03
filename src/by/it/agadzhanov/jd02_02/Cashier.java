package by.it.agadzhanov.jd02_02;

public class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "Кассир №" + number;
    }

    @Override
    public void run() {
        Dispatcher.cashierList.add(this);
        System.out.println(this + " начал работу");

        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.callFromQueue();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer);
                int serviceTime = Util.randomFromTo(2000, 5000);
                try {
                    Util.sleepAccelerated(serviceTime);
                } catch (InterruptedException e) {
                    System.out.println(this + ": ожидание завершено некорректно при вызове run()!");
                }
                System.out.println("$$$ " + buyer + " купил " + buyer.getBasket());
                System.out.println(this + " закончил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
                /*
                synchronized (Dispatcher.monitor) {
                    if (Dispatcher.cashiersNeeded < Dispatcher.cashierCount) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Ожидание " + this + " было прервано!");
                        }
                    }
                }
                */
            } else {
                synchronized (this) {
                    try {
                        this.wait(1000 / Dispatcher.timeFactor);
                    } catch (InterruptedException e) {
                        System.out.println("Ожидание " + this + " было прервано!");
                    }
                }
            }
        }

        System.out.println(this + " закончил работу");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
