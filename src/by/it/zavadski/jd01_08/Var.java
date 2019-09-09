package by.it.zavadski.jd01_08;

abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна",this,other);
        return null;
    }

    public String toString(){return "Abstract class Var";}

}
