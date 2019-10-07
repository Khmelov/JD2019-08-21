package by.it.shamuradova.jd02_02;


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




        //}

//        int countBuyers = 0;
//        for (int i = 0; i < 120; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.err.println(e);
//            }
//            int count = Rnd.fromTo(0, 2);
//            for (int j = 0; j < count; j++) {
//                countBuyers++;
//                boolean retiree = count % 4 == 0;
//                Buyer buyer = new Buyer(retiree, shop.listOfGoods);
//
//            }
//        }


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