package by.it.boytsov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Class<Param> paramClass = Param.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods)
            if (method.isAnnotationPresent(paramClass)) {
                Param annotation = method.getAnnotation(paramClass);
                int paramA = annotation.a();
                int paramB = annotation.b();
                Object invokeObject = method.invoke(beanClass.getConstructor().newInstance(), paramA, paramB);
                System.out.printf("%s %s\n", method.getName(), invokeObject.toString());
            }
    }

    public BeanTester() {
    }
}