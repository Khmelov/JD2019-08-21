package by.it.rubatskii.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BasketStack {

    private static BlockingDeque<Basket> basketStack = new LinkedBlockingDeque<>(50);

    static {
        while (basketStack.remainingCapacity() != 0) {
            try {
                basketStack.put(new Basket());
            } catch (InterruptedException e) {
                System.out.println("exception create basket!");
            }
        }
    }

    static Basket takeBasket() throws InterruptedException {
        return basketStack.takeFirst();
    }

    static void putBasketBack() {
        try {
            basketStack.putFirst(new Basket());
        } catch (InterruptedException e) {

            System.out.println("return basket interrupted");
        }
    }
}
