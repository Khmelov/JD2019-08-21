package by.it.shamuradova.jd02_01;

public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addToList(new Good("milk", 1.5));
        shop.addToList(new Good("bread", 1.5));
        shop.addToList(new Good("meat", 5.0));
        shop.addToList(new Good("cheese", 3.0));
        shop.addToList(new Good("chocolate", 1.0));
        shop.addToList(new Good("juice", 3.0));

        int countBuyers = 0;
        for (int i = 0; i < 120; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            int count = Rnd.fromTo(0, 2);
            for (int j = 0; j < count; j++) {
                countBuyers++;
                boolean retiree = count % 4 == 0;
                Buyer buyer = new Buyer(countBuyers, retiree, shop.listOfProducts);
            }
        }
    }
}