package by.it.boytsov.jd02_02;

import java.util.*;

public class Market {

    private static List<Thread> peopleList = new ArrayList<>();

        public static void main (String[] args) {

            System.out.println("Market opened");

            for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                Thread thread = new Thread(cashier);
                peopleList.add(thread);
                Dispatcher.cashierList.add(cashier);
                thread.start();
            }

            while (!Dispatcher.planComplete()) {
                int buyersEntered = Util.randomUpTo(2);
                for (int j = 1; j <= buyersEntered; j++) {
                    if (!Dispatcher.planComplete()) {
                        Buyer buyer = new Buyer();
                        peopleList.add(buyer);
                        buyer.start();
                    }
                }
                try {
                    Util.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main:exception sleep!");
                }
            }
            preventFromClosing();
            System.out.println("Market closed");
        }
        private static void preventFromClosing() {
            for (Thread person : peopleList) {
                try {
                    person.join();
                } catch (InterruptedException e) {
                }
            }
        }
}

