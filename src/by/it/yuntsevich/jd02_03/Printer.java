//package by.it.yuntsevich.jd02_03;
//
//class Printer {
//    private static int amount = 0;
//
//
//    static void print(Cashier cashier, Buyer buyer) {
//
//        StringBuilder out = new StringBuilder();
//
//        int buyerAmount = 0;
//
//        for (String s : buyer.getGood()) {
//            buyerAmount += Goods.getPrice(s);
//        }
//
//        amount +=buyerAmount;
//
//
//
//        out.append("___________________________________________________________________________________________________________________________");
//        out.append("\n");
//        out.append("Кассир 1       ").append("Кассир 2       ").append("Кассир 3       ").append("Кассир 4       ").append("Кассир 5       ").append("Размер очереди ").append("  Общая выручка ");
//        if (cashier.getNumber() == 0) {
//            out.append("\n");
//            out.append(buyer.getName()).append("                                                                   ").append(QueueBuyers.length()).append("         ").append(amount).append("\n");
//            for (String s : buyer.getGood()) {
//                out.append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
//            }
//            out.append("Total-").append(buyerAmount).append("\n");
//        } else if (cashier.getNumber() == 1) {
//            out.append("\n");
//            out.append("               ").append(buyer.getName()).append("                                                    ").append(QueueBuyers.length()).append("         ").append(amount).append("\n");
//            for (String s : buyer.getGood()) {
//                out.append("               ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
//            }
//            out.append("               ").append("Total-").append(buyerAmount).append("\n");
//        } else if (cashier.getNumber() == 2) {
//            out.append("\n");
//            out.append("                              ").append(buyer.getName()).append("                                     ").append(QueueBuyers.length()).append("         ").append(amount).append("\n");
//            for (String s : buyer.getGood()) {
//                out.append("                              ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
//            }
//            out.append("                              ").append("Total-").append(buyerAmount).append("\n");
//        } else if (cashier.getNumber() == 3) {
//            out.append("\n");
//            out.append("                                             ").append(buyer.getName()).append("                      ").append(QueueBuyers.length()).append("         ").append(amount).append("\n");
//            for (String s : buyer.getGood()) {
//                out.append("                                             ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
//            }
//            out.append("                                             ").append("Total-").append(buyerAmount).append("\n");
//        } else if (cashier.getNumber() == 4) {
//            out.append("\n");
//            out.append("                                                            ").append(buyer.getName()).append("       ").append(QueueBuyers.length()).append("         ").append(amount).append("\n");
//            for (String s : buyer.getGood()) {
//                out.append("                                                            ").append(s).append(" - ").append(Goods.getPrice(s)).append("\n");
//            }
//            out.append("                                                            ").append("Total-").append(buyerAmount).append("\n");
//        }
//        out.append("___________________________________________________________________________________________________________________________");
//
//        System.out.println(out.toString());
//    }
//}
