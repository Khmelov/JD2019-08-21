package by.it.yuntsevich.jd02_02;

public class Cashier implements Runnable {
    private String name;

    Cashier(int number){
        name = "Кассир " + number;
    }
    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while(Dispathcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }

            }
            else{
                Util.sleep(1); // bad solution
            }
        }
        System.out.println(this + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
