package by.it.kiturka.jd02_02;


public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();

        shop.addToList(new Good("milk", 1.5));
        shop.addToList(new Good("bread", 1.5));
        shop.addToList(new Good("meat", 5.0));
        shop.addToList(new Good("cheese", 3.0));
        shop.addToList(new Good("chocolate", 1.0));
        shop.addToList(new Good("juice", 3.0));
        shop.addToList(new Good("sweets", 2.0));
        shop.addToList(new Good("bread", 1.5));
        shop.addToList(new Good("apples", 1.5));
        shop.addToList(new Good("potato", 2.5));
        shop.addToList(new Good("tomato", 1.5));
        shop.addToList(new Good("sugar", 1.0));
        shop.addToList(new Good("salt", 1.5));


        //while(!Dispatcher.planComplete()){
        for (int i = 0; i < Dispatcher.getMax(); i++) {
            boolean retiree = i % 4 == 0;
            Buyer b = new Buyer(retiree, shop.listOfGoods);
        }
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.start();


    }
}