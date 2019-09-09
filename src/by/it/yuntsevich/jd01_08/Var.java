package by.it.yuntsevich.jd01_08;

public abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна.\n",this.toString(), other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна.\n",this.toString(), other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна.\n",this.toString(), other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна.\n",this.toString(), other);
        return null;
    }

    @Override
    public String toString() {
        return "{Abstract var}";

    }
}

