package com.smart.reflect;

/**
 * Created by nanca on 10/26/2017.
 */
public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("drive private car! the color is:" + color);
    }
}
