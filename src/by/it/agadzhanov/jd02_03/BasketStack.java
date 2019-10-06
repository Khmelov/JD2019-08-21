package by.it.agadzhanov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BasketStack {

    private static BlockingDeque<Basket> basketStack = new LinkedBlockingDeque<>(50);

    static {
        while (basketStack.remainingCapacity() != 0) {
            try {
                basketStack.put(new Basket());
            } catch (InterruptedException e) {
                System.out.println("Создание корзин было прервано!");
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

            System.out.println("Возвращение корзины было прервано!");
        }
    }
}
