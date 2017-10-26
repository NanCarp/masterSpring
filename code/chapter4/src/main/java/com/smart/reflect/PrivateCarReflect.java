package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by nanca on 10/26/2017.
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[])null);

        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar, (Object[]) null);
    }
}
