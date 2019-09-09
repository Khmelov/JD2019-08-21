package by.it.agadzhanov.jd01_08;

abstract class Var implements Operation{

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" и "+other+" невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" из "+other+" невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" на "+other+" невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" на "+other+" невозможно");
        return null;
    }
}
