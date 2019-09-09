package by.it.zlotnikova.jd01_08;

abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s и %s невозможна.\n", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s и %s невозможна.\n", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s и %s невозможна.\n", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s и %s невозможна.\n", this.toString(), other.toString());
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
