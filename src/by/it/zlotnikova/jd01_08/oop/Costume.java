package by.it.zlotnikova.jd01_08.oop;

public class Costume extends Clothes {

    private double price = 350;

    @Override
    public void showPrice() {
        System.out.println("Цена: " + this.price);
    }

    @Override
    public void buy() {
        System.out.println("Можно купить в крупных или специализиронных магазинах.");
    }

    @Override
    public void clean() {
        System.out.println("Рекомендуется химчистка.");
    }

    @Override
    public void iron() {
        super.iron();
    }

    @Override
    public void store() {
        System.out.println("Хранить на вешалке.");
    }

    @Override
    public void useForHomeDecoration() {
        super.useForHomeDecoration();
    }

    @Override
    public void recycleOrReuse() {
        super.recycleOrReuse();
    }

    @Override
    public String toString() {
        return "Это класс Clothes.";
    }
}

