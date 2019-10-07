package by.it.shamuradova.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    //нужно, чтобы очередь была в единственном экземпляре или LinkedList
    private static final BlockingDeque<Buyer> dequeOfBuyers = new LinkedBlockingDeque<>(30); //монитор, final -гарантия, что адрес (ссылка на объект) в памяти не изменится и монитор не изменится
    private static final BlockingDeque<Buyer> dequeOfRetiree = new LinkedBlockingDeque<>();
    //добавляем покупателя в очередь. Покупатель будет вызывать этот метод
    static void addBuyerInQueue(Buyer buyer) {
        if (buyer.retiree) {
            try {
                dequeOfRetiree.putLast(buyer);    //put!!! в этом случае поток будет ожидать, пока освободится место
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                dequeOfBuyers.putLast(buyer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //извлекаем покупателя из очереди, метод для кассира
    static Buyer extract() {
        if (!dequeOfRetiree.isEmpty()) {
            return dequeOfRetiree.pollFirst();
        } else {
            synchronized (dequeOfBuyers) {
                Buyer buyer = dequeOfBuyers.pollFirst();
                return buyer;
            }
        }
    }
    //кассир проверяет, сколько осталось в очереди человек, если нету, можно закрываться
    static int getCount() {
        return dequeOfBuyers.size();
    }
}











