package by.it.rubatskii.jd02_02;

import java.util.*;

public class Market {

    static Map<String, Double> goodsList = new HashMap<>(15);

    static Map.Entry<String, Double> getRandomGoods() {
        goodsList.putIfAbsent("Milk", 1.66);
        goodsList.putIfAbsent("Cheese", 9.22);
        goodsList.putIfAbsent("Bread", 1.47);
        goodsList.putIfAbsent("Meat", 9.82);
        goodsList.putIfAbsent("Juice", 6.11);
        goodsList.putIfAbsent("Pasta", 5.25);
        goodsList.putIfAbsent("Sushi", 22.05);
        Set<Map.Entry<String, Double>> entries = goodsList.entrySet();
        Iterator<Map.Entry<String, Double>> itr = entries.iterator();
        int number = Util.random(1, goodsList.size());
        int i = 0;
        while (itr.hasNext()) {
            i++;
            if (i == number)
                return itr.next();
            else itr.next();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");


        List<Thread> actorList = new ArrayList<>(200);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            actorList.add(thread);
            thread.start();
        }
        while (!Dispatcher.planComplete()) {
            for (int time = 1; time <= 120; time++) {
                int countBuyer = Util.random(2);
                for (int i = 0; i < countBuyer; i++) {
                    if (!Dispatcher.planComplete()) {
                        Buyer buyer = new Buyer();
                        actorList.add(buyer);
                        buyer.start();
                    }
                    Util.sleep(1000);
                }
                for (Thread actor : actorList) {
                    actor.join();
                }

                }

                System.out.println("Market closed");
            }

        }
    }

