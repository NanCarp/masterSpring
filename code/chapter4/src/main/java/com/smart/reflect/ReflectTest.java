package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by nanca on 10/26/2017.
 */
public class ReflectTest {
    public static Car initByDefaultConnst() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConnst();
        car.introduce();
    }
}
