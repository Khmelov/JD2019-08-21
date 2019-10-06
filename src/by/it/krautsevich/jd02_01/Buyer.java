package by.it.krautsevich.jd02_01;

import java.util.*;

class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {

    int num ;
    int sum ;
    List<String> mySet ;



    public Buyer (int num) {
        this.num = num ;
        this.setName("Покупатель № " + num + " ") ;
        this.sum = 0 ;
        this.mySet = new ArrayList<>() ;                //сюда сложим названия выбранных товаров



        start();
    }

    @Override
    public  void run() {
        enterToMarket();
        takeBasket();
        putGoodsToBasket();
        chooseGoods();
        goToOut();
    }

    @Override
    public String toString() {return this.getName() ;}

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин (==>)");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина (<==)");
    }

    @Override
    public void chooseGoods() {
        try{
            int pause = Rnd.fromTo(500 , 2000) ;
            Thread.sleep(pause);
        }
        catch (InterruptedException e) {
            System.out.println(this + "задерживается в магазине");
        }
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void takeBasket() {
        try {
        int pause = Rnd.fromTo(100 , 200);
        Thread.sleep(pause);
        System.out.println(this + "взял корзинку");
    }
        catch (InterruptedException e) {
            System.out.println(this + "не может найти корзинку");}
        }

    @Override
    public void  putGoodsToBasket() {try {
        int pause = Rnd.fromTo(100 , 200);
        Thread.sleep(pause);
        int numberOfGoods = Rnd.fromTo(1, 4);                  // начинаем выбирать товары

        HashMap <String, Integer> listOfGoods = new HashMap<>() ;
        listOfGoods.put("Хлеб" , 5) ;
        listOfGoods.put("Картошка" , 3) ;
        listOfGoods.put("Селедка" , 10) ;
        listOfGoods.put("Мясо" , 15) ;
        listOfGoods.put("Макароны", 4);
        listOfGoods.put("Консервы", 8);
        listOfGoods.put("Курица", 9);
        listOfGoods.put("Батон", 5);
        listOfGoods.put("Водка" , 12) ;
        listOfGoods.put("Пиво" , 5) ;
        listOfGoods.put("Морковь", 3);
        listOfGoods.put("Лук", 2);
        listOfGoods.put("Мука", 6);
        listOfGoods.put("Мороженное", 6);
        listOfGoods.put("Шоколад", 6);

        Set<Map.Entry<String, Integer>> entry_set = listOfGoods.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entry_set.iterator() ;

/*        for (int i = 0; i < numberOfGoods & (it.hasNext()) ; )    // этот вариант работает , но корзины получаются одинаковые
         {
                Map.Entry<String, Integer> me = it.next() ;
                sum = sum + me.getValue() ;
                mySet.add(me.getKey()) ;
                i++ ;
         }   */

        int i = 0 ;                                              // этот вариант работает, но комп подвисает
        while (i < numberOfGoods) {
            if (!it.hasNext()) {entry_set = listOfGoods.entrySet();}

            else
            for (; i < numberOfGoods & (it.hasNext()) ; ) {
                Map.Entry<String, Integer> me = it.next() ;
                int myTry = Rnd.fromTo(0 , 1);
                if (myTry !=0) {sum = sum + me.getValue() ;
                            mySet.add(me.getKey()) ;
                            i++ ;}
                else {it.next() ;}
            }
        }

        StringBuilder myString = new StringBuilder();
        myString.append(this).append(" положил в корзинку: ");
        String delimeter = "";
        for ( String good : mySet) {
            myString.append(delimeter) ;
            myString.append(good);
            delimeter = ", " ;
        }
        myString.append("; сумма покупки = ").append(sum).append("рублей.");

        System.out.println(myString);
    }
    catch (InterruptedException e) {
        System.out.println(this + "не может выбрать товар");}}
}
