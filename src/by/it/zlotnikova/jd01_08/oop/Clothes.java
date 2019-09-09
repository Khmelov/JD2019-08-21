package by.it.zlotnikova.jd01_08.oop;

abstract class Clothes implements Textile{

    @Override
    public void showPrice() {
        System.out.println("Цена не определена");
    }

    @Override
    public void buy() {
        System.out.println("Неизвестно.");
    }

    @Override
    public void clean() {
        System.out.println("Стирка запрещена.");
    }

    @Override
    public void iron() {
        System.out.println("Гладить запрещено.");
    }

    @Override
    public void store() {
        System.out.println("Рекомендации по хранению не определены.");
    }

    @Override
    public void useForHomeDecoration() {
        System.out.println("Не используется для декора дома.");
    }

    @Override
    public void recycleOrReuse() {
        System.out.println("Подлежит переработке.");
    }

    @Override
    public String toString() {
        return "Это класс Clothes.";
    }
}
