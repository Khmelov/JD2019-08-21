package by.it.kiturka.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {
    private static BlockingDeque<Buyer> deque=new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer)  {
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract(){
    return deque.pollFirst();
    }
    static int buyersInQueue(){
        return deque.size();
    }
}
