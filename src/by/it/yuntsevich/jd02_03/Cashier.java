package by.it.yuntsevich.jd02_03;

public class Cashier implements Runnable {
    private String name;

    private int number=0;

    Cashier(int number){
        name = "Кассир " + number;
    }

    int getNumber() {
        return number;
    }
    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while(Dispathcher.marketIsOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer);
                int timeout = Util.random(2000, 5000);
              //  Printer.print(this, buyer);
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.setiWait(false);
                    buyer.notifyAll();
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
