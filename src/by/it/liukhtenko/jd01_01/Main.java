package by.it.liukhtenko.jd01_01;

public class Main {

    public static void main(String[] args) {
    	// write your code here
      Hello hello =  new Hello();
      hello.printSlogan();
      hello.setSlogan("Привет мир");
      hello.printSlogan();
      Args argobject = new Args(args);
      argobject.printArgs();
    }
}
