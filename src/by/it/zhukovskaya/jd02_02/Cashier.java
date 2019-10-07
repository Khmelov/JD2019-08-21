package by.it.zhukovskaya.jd02_02;

import com.sun.javaws.IconUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cashier implements Runnable {
    private String name;

    public  Cashier(int number) {
        name = "Cashier " + number;
    }

    @Override
    public void run() {
        while(Dispathcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " start service " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println("the basket of " + buyer + ":");
                printBasket(buyer.getBasket().entrySet());
                System.out.println(this + " stop service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Util.sleep(1);//bad solution
            }
        }
    }

    private void  printBasket(Set<Map.Entry<String, Double>> basket) {
        Iterator<Map.Entry<String, Double>> itrBasket = basket.iterator();
        double sumPrice = 0;
        while (itrBasket.hasNext()) {
            Map.Entry<String, Double> goods = itrBasket.next();
            System.out.println(goods.getKey()+" - " + goods.getValue());
            sumPrice += goods.getValue();
        }
        System.out.println("Summary priсe: " + Math.round(sumPrice*100)/100.0);
    }

    @Override
    public String toString() {
        return name;
    }

}
