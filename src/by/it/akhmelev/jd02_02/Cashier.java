package by.it.akhmelev.jd02_02;

import java.util.Set;

public class Cashier implements Runnable {
    private String name;
    private int number;

    public Cashier(int number) {
        name = "--Cashier " + number;
        this.number = number;
    }

    private void printCheck(Buyer buyer) {
        StringBuilder out = new StringBuilder();
        int tab = 20 * (number - 1) + 1;
        int tab2 = 20 * (5 - number) + 1;
        String formatHeader = "\n%" + tab + "sCasier №%-1d\n";
        out.append(String.format(formatHeader, " ", number));
        String formatGood = "%" + tab + "s%-6s: $%-6.2f\n";

        Set<Good> backet = buyer.getBacket();
        double sum = 0;
        for (Good good : backet) {
            out.append(String.format(formatGood, " ", good.getName(), good.getPrice()));
            sum += good.getPrice();
        }

        String formatTotal = "%" + tab + "s%-6s: $%-6.2f %" + tab2 + "sTOTAL: $%-8.3f\n\n";
        Dispatcher.addMoney(sum);
        out.append(String.format(formatTotal, "", buyer, sum, " ", Dispatcher.getTotalMoney()));
        System.out.println(out);
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void run() {
        System.out.println(this + " OPENED");
        while (Dispatcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " start service " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                printCheck(buyer);
                System.out.println(this + " stop service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(1); //bad solution
            }
        }
        System.out.println(this + " CLOSED");
    }

    @Override
    public String toString() {
        return name;
    }
}
