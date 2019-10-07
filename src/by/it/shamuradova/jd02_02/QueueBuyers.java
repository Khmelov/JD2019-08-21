package by.it.shamuradova.jd02_02;


import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    //нужно, чтобы очередь была в единственном экземпляре или LinkedList
    private static final Deque<Buyer> queueOfBuyers = new ArrayDeque<>(); //монитор, final -гарантия, что адрес (ссылка на объект) в памяти не изменится и монитор не изменится
    private static final Deque<Buyer> queueOfRetiree = new ArrayDeque<>();

    //добавляем покупателя в очередь. Покупатель будет вызывать этот метод
    static void addBuyerInQueue(Buyer buyer) {//синхронизация по монитору
        if (buyer.retiree) {
            synchronized (queueOfRetiree) {
                queueOfRetiree.addLast(buyer);
            }
        } else {
            synchronized (queueOfBuyers) {
                queueOfBuyers.addLast(buyer); //критическая секция, пока добавяется покупатель, другой покупатель не должен сюда попасть
            }
        }
    }

    //извлекаем покупателя из очереди, метод для кассира
    static Buyer extract() {
        if (!queueOfRetiree.isEmpty()) {
            synchronized (queueOfRetiree) {
                return queueOfRetiree.pollFirst();
            }
        } else {
            synchronized (queueOfBuyers) {
                Buyer buyer = queueOfBuyers.pollFirst();  //poolFirst();
                return buyer;
            }
        }
    }

    //кассир проверяет, сколько осталось в очереди человек, если нету, можно закрываться
    static int getCount() { //данные только читаем,  можно не синхранизировать
        return queueOfBuyers.size();
        // чуть что исправить на sychronized!!!
    }
}











