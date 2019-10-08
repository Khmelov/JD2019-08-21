package by.it.akhrem.calc;

public abstract class Creator {
    public abstract Var factoryMethod(String str);
}

class CreatorScalar extends Creator {

    @Override
    public Var factoryMethod(String str) {
        return new Scalar(str);
    }
}

class CreatorVector extends Creator {

    @Override
    public Var factoryMethod(String str) {
        return new Vector(str);
    }
}

class CreatorMatrix extends Creator {

    @Override
    public Var factoryMethod(String str) {
        return new Matrix(str);
    }
}
