package by.it.shamuradova.jd02_03;


import java.util.ArrayList;

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

        for(int i=0; i<50; i++){
            Shop.returnBasket(new Basket());
        }
        ArrayList<Thread> actorList = new ArrayList<>(200);
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            actorList.add(thread);
            thread.start();
        }

        while (!Dispatcher.planComplete()){
            Thread.sleep(1000);
            for (int i = 0; i < Dispatcher.getMax(); i++) {
                boolean retiree = i % 4 == 0;
                Buyer b = new Buyer(retiree, shop.listOfGoods);
                actorList.add(b);
            }
            for (Thread actor : actorList) {
                actor.join();
            }
            System.out.println("Магазин закрыт");
        }



//        Dispatcher dispatcher = new Dispatcher();
//        dispatcher.start();

//        dispatcher.join();
//        System.out.println("Магазин закрыт!!!");


//        //int countBuyers=0;
//        while (!Dispatcher.planComplete()) {
//            //int max = Rnd.random(2);
//            for (int i = 0; i < Dispatcher.getMax(); i++) {
//                boolean retiree = Dispatcher.buyerInMarket() % 4 == 0;
//                Buyer buyer = new Buyer(retiree, shop.listOfGoods);
//                //actorList.add(buyer);
//                buyer.start();
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
////        for (Thread actor : actorList) {
////            actor.join();
////        }
//        System.out.println("Market closed");
//        //List<Thread> actorList = new ArrayList<>(200);
//        for (int i = 1; i <= 2; i++) {
//            Cashier cashier = new Cashier(i);
//            Thread thread = new Thread(cashier);
//           // actorList.add(thread);
//            thread.start();
//        }

//        Dispatcher d =new Dispatcher();
//        d.start();

        //while(shop.shopIsOpened())


    }
}