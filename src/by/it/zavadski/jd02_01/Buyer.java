package by.it.zavadski.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static by.it.zavadski.jd02_01.Util.random;

public class Buyer extends Thread implements IBuyer,IUseBasket{
    Buyer (int number){
        super("Buyer-"+number);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%-10s ENTERED\n",this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%-10s choosing goods\n",this);
        int timeout = random(2000);
        Util.sleep(timeout);
        System.out.printf("%-10s chose goods\n",this);
    }

    @Override
    public void goOut() {
        System.out.printf("%-10s LEFT\n",this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%-10s took basket\n",this);
        
    }

    @Override
    public void putGoodsToBasket() {
        long timeStamp=System.nanoTime();
        Util.sleep(random(100,200));
        ArrayList<String> goodsNames=new ArrayList<>(Dispatcher.chooseGoods().keySet());
        System.out.printf("%-10s put in basket:\n",this);
        for (int i = 0; i <random(1,4) ; i++) {
            String inBasket=goodsNames.get(random(0,goodsNames.size()-1));
            Double price=Dispatcher.chooseGoods().get(inBasket);
            System.out.printf("\t%tT %-9s %-3.2f \n",timeStamp,inBasket,price);
        }
    }
}
