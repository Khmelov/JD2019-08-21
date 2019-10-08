package by.it.krautsevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Cashiers_Boss implements Runnable{

    private volatile int numberOfCashiers = 1 ;
    private int neededNumber;
    Deque<Thread> dequeueOfCashiers = new ArrayDeque<>(10) ;

    @Override
    public void run() {

        Cashier cashier = new Cashier(1) ;
        Thread thread = new Thread(cashier) ;
        Market.queue.add(thread);
        dequeueOfCashiers.add(thread) ;
        thread.start();

        while (Dispatcher.marketIsOpened())
        {
            neededNumber = QueueBuyers.getSizeOfDeque() - (QueueBuyers.getSizeOfDeque()%5) /5;
            if ( (neededNumber > numberOfCashiers) && (numberOfCashiers <6) ) {
                numberOfCashiers++ ;
                Cashier oneMoreCashier = new Cashier(numberOfCashiers) ;
                Thread new_thread = new Thread(oneMoreCashier) ;
                Market.queue.add(new_thread);
                dequeueOfCashiers.add(new_thread) ;
                new_thread.start();
            }
            if ( (neededNumber > numberOfCashiers) && (numberOfCashiers!=1)) {
                Thread my_cashier = dequeueOfCashiers.pollLast();
                }

            }
        }
    }

