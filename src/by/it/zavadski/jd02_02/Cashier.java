package by.it.zavadski.jd02_02;

import static by.it.zavadski.jd02_02.Dispatcher.marketIsOpened;
import static by.it.zavadski.jd02_02.Util.random;
import static by.it.zavadski.jd02_02.Util.sleep;

public class Cashier implements Runnable {
    private String name;

    Cashier(int number){
        name="Cashier "+number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (marketIsOpened()){
        Buyer buyer = QueueBuyers.extract();
        if (buyer !=null){
        System.out.printf("%-9s started processing %10s\n",this,buyer);
        int timeout = random(2000, 5000);
        sleep(random(timeout));
        System.out.printf("%-9s finished processing %10s\n",this,buyer);
        synchronized (buyer){
            buyer.notifyAll();
        }
    }
    else {
        sleep(1);
    }

}
    }
}
