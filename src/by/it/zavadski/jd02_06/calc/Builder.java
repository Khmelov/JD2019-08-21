package by.it.zavadski.jd02_06.calc;

    abstract class VarsCreator {
    public abstract Var createVar(String str);
    }
    class ScalarCreator extends VarsCreator {
        @Override
        public Var createVar(String str) { return new Scalar(str);
        }
    }

    class VectorCreator extends VarsCreator {
        @Override
        public Var createVar(String str) { return new Vector(str);
        }
    }

    class MatrixCreator extends VarsCreator {
        @Override
        public Var createVar(String str) { return new Matrix(str);
        }
    }
