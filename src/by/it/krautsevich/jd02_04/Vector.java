package by.it.krautsevich.jd02_04;

import java.util.Arrays;

public class Vector extends Var {

    private double [] value;

    public Vector (double [] values) {
        this.value = Arrays.copyOf(values, values.length) ;
    }

    public Vector (Vector otherVector) {
        this.value = otherVector.value ;
    }

    public  Vector (String stringVector) {
        String itWillBeVector = new String(stringVector.replace("{"," ")) ;
        String itWillBeVector2 = new String(itWillBeVector.replace("}","").trim()) ;
        String [] itWillBe = itWillBeVector2.split(",") ;
        double [] newVector = new double[itWillBe.length] ;
        for (int i = 0; i < itWillBe.length; i++) {
            newVector[i] = Double.parseDouble(itWillBe[i]) ;
        }
        this.value = newVector ;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double res[] = Arrays.copyOf(this.value , this.value.length) ;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar)other).getValue() ;
            }
            return new Vector(res) ;
        }
        else if (other instanceof Vector) {
            double res[] = Arrays.copyOf(this.value , this.value.length) ;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector)other).value[i] ;
            }
            return new Vector(res) ;
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double res[] = Arrays.copyOf(this.value , this.value.length) ;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]/((Scalar)other).getValue() ;
            }
            return new Vector(res) ;
        }
        return super.div(other);
    }

    @Override
    public Var mul(Var other) {if (other instanceof Scalar) {
        double res[] = Arrays.copyOf(this.value , this.value.length) ;
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i]*((Scalar)other).getValue() ;
        }
        return new Vector(res) ;
    }
    else if (other instanceof Vector) {
        double res[] = Arrays.copyOf(this.value , this.value.length) ;
        double result =0 ;

        for (int i = 0; i < res.length; i++) {
            result = result + res[i]*((Vector)other).value[i] ;
            }
        return new Scalar(result) ;
    }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {if (other instanceof Scalar) {
        double res[] = Arrays.copyOf(this.value , this.value.length) ;
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] - ((Scalar)other).getValue() ;
        }
        return new Vector(res) ;
    }
    else if (other instanceof Vector) {
        double res[] = Arrays.copyOf(this.value , this.value.length) ;
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] - ((Vector)other).value[i] ;
        }
        return new Vector(res) ;
    }
        return super.sub(other);
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder("{");
        String delimeter = "" ;
        for (double v : value) {sb.append(delimeter).append(v);
        delimeter = ", " ;}
        sb.append('}') ;
        return sb.toString() ;
    }
}
