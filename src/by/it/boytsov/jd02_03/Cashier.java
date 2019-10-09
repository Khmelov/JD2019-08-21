package by.it.boytsov.jd02_03;

public class Cashier implements Runnable {
    private String name;
    private int money=0;

    Cashier(int number) {
        name = "Cashier №" + Dispatcher.cashierStartWorking();
    }

    public Cashier() {

    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {

        Dispatcher.cashierRevenueMap.put(this, 0);
        System.out.println(this + " Cashier started ");


        while (Dispatcher.marketIsOpen()) {
            Buyer buyer = BuyersQueue.callFromQueue();
            if (buyer != null) {
                Dispatcher.buyerExitQueue();
                System.out.println(this + " started to work " + buyer);
                int serviceTime = Util.randomFromTo(2000, 5000);
                try {
                    Util.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int moneyEarned = buyer.getBasket().getTotalMoneySpent();
                money = money + moneyEarned;
                Dispatcher.cashierRevenueMap.replace(this, money);
                Dispatcher.totalRevenue.getAndAdd(moneyEarned);

                synchronized (buyer) {
                    buyer.resetWaiting();
                    buyer.notifyAll();
                }
                System.out.println(buyer + " buy " + buyer.getBasket());
                Dispatcher.printData();
                System.out.println(this + " finished serving " + buyer);
            } else {

                try {
                    Util.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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