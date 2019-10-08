package by.it.rubatskii.jd02_03;

public class Cashier implements Runnable {

    private String name;
    private int moneyInCashBox = 0;

    Cashier() {
        name = "Cashier №" + Dispatcher.cashierStartWorking();
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        Dispatcher.cashierRevenueMap.put(this, 0);
        System.out.println(this + "started Cashier ");

        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.callPensionerFromQueue();
            if (buyer == null) {
                buyer = BuyersQueue.callBuyerFromQueue();
            }
            if (buyer != null) {
                Dispatcher.buyerExitQueue();
                System.out.println(this + " started to work " + buyer);
                int serviceTime = Util.randomFromTo(2000, 5000);
                Util.sleepAccelerated(serviceTime);

                int moneyEarned = buyer.getBasket().getTotalMoneySpent();
                moneyInCashBox = moneyInCashBox + moneyEarned;
                Dispatcher.cashierRevenueMap.replace(this, moneyInCashBox);
                Dispatcher.totalRevenue.getAndAdd(moneyEarned);

                synchronized (buyer) {
                    buyer.resetWaiting();
                    buyer.notifyAll();
                }
                System.out.println(buyer + " buy " + buyer.getBasket());
                Dispatcher.printData();
                System.out.println(this + " finished serving " + buyer);
            } else {
                Util.sleepAccelerated(1000);
            }
        }

        System.out.println(this + " finished work");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
