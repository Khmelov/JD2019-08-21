package by.it.shamuradova.calc3;

abstract class Var implements Operation {

    static ResManager manager = ResManager.INSTANCE;

    @Override
    public String toString() {
        return manager.getKey(Message.VAR);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(manager.getKey(Message.ADD) + this + "+" + other);
    }
    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(manager.getKey(Message.SUB) + this + "-" + other);
    }
    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(manager.getKey(Message.MUL) + this + "*" + other);
    }
    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(manager.getKey(Message.DIV) + this + "/" + other);
    }
}
