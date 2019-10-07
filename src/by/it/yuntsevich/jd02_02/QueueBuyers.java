package by.it.yuntsevich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

 class QueueBuyers {
    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Buyer> dequePensioneer = new LinkedList<>();

    //sync QueueBuyers.class
    static synchronized void addBuyer(Buyer buyer){
        if (buyer.isPensioneer()){
            dequePensioneer.addLast(buyer);
        }
        else deque.addLast(buyer);
    }

    static synchronized Buyer extract(){
        if (!dequePensioneer.isEmpty()){
            return dequePensioneer.pollFirst();
        }
        else return deque.pollFirst();
    }

     synchronized static Deque<Buyer> getDeque() {
         return deque;
     }
 }
