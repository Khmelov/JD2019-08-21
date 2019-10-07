package by.it.yuntsevich.jd02_02;

import java.util.*;

public class Runner {


    private static Map<String, Double> goods = new HashMap<>(20);

    static Map.Entry<String, Double> takeGoods() {
        goods.put("Гречка", 1.0);
        goods.put("Сахар", 0.99);
        goods.put("Хлеб", 0.8);
        goods.put("Огурец", 3.6);
        goods.put("Молоко", 2.0);
        goods.put("Курица", 8.6);
        goods.put("Капуста", 0.68);
        goods.put("Макароны", 2.9);
        goods.put("Картофель", 0.86);
        goods.put("Мука", 1.57);
        Set<Map.Entry<String, Double>> entries = goods.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        int number = Util.random(1, goods.size());
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            if (i == number)
                return iterator.next();
            else iterator.next();
        }
        return null;
    }


    public static void main(String[] args) {
        int numberBuyers = 0;
        System.out.println("Магазин открыт");

        List<Thread> actorList = new ArrayList<>(200);
        // List<Thread> cashierList = new ArrayList<>(5);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            actorList.add(thread);
            thread.start();
        }

        generateBuyers(numberBuyers, actorList);

        for (Thread thread : actorList)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Магазин закрыт");
    }


    private static void generateBuyers(int numberBuyers, List<Thread> actorList) {
        while (!Dispathcher.planComplete()) {
            int countBuyers = Util.random(2);
            for (int i = 0; i < countBuyers; i++) {
                if (!Dispathcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyers);
                    System.out.println(QueueBuyers.getDeque().size());
                    if (numberBuyers % 4 == 0) {
                        buyer.setPensioneer(true);
                    }
                    actorList.add(buyer);
                    buyer.start();
//                    if (QueueBuyers.getDeque().size() == 5 && cashierList.size() == 0) {
//                            addCashier(cashierList);
//
//
//                    } else if (QueueBuyers.getDeque().size() > 5 && QueueBuyers.getDeque().size() < 11) {
//                        while (cashierList.size() < 2) {
//                            addCashier(cashierList);
//                            // add 2 cashier
//                        }
////                        // leave 1 cashier
//                    } else if (QueueBuyers.getDeque().size() == 11) {
//                        while (cashierList.size() < 3) {
//                            addCashier(cashierList);
//                        }
////
//                    } else if (QueueBuyers.getDeque().size() > 11 && QueueBuyers.getDeque().size() < 16) {
//                        if (cashierList.size() > 3) {
//                            for (int j = 3; j < cashierList.size(); j++) {
//                                cashierList.get(i).stop();
//                            }
//
//                        }
//                    } else if (QueueBuyers.getDeque().size() == 16) {
//                        while (cashierList.size() < 4) {
//                            addCashier(cashierList);
//                        }
//
//                    } else if (QueueBuyers.getDeque().size() > 16 && QueueBuyers.getDeque().size() < 21) {
//                        if (cashierList.size() > 4) {
//                            for (int j = 4; j < cashierList.size(); j++) {
//                                cashierList.get(i).stop();
//                            }
//
//                        }
//                    } else if (QueueBuyers.getDeque().size() == 21) {
//                        while (cashierList.size() < 5) {
//                            addCashier(cashierList);
//                        }
//                    } else if (QueueBuyers.getDeque().size() > 21) {
//                        if (cashierList.size() > 5) {
//                            for (int j = 5; j < cashierList.size(); j++) {
//                                cashierList.get(i).stop();
//                            }
//                        }
//                    }
//                } else if (QueueBuyers.getDeque().size() < 1) {
//                    cashierList.forEach(Thread::stop);
//
//                }
                }
                Util.sleep(1000);
            }

        }
    }
}

