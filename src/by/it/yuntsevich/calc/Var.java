package by.it.yuntsevich.calc;

public abstract class Var implements Operation {
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "+" + other );
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "-" + other);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "*" + other);

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE) + this + "/" + other);

    }

    @Override
    public String toString() {
        return "{Abstract var}";

    }


}

