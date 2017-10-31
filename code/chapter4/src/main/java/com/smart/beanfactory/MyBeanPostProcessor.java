package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by nanca on 10/31/2017.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car)bean;
            if (car.getColor() == null) {
                System.out.println("调用 BeanPostProcessor.postProcessBeforeInitialization," +
                        "color 为空，设置颜色为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car)bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("");
            }
            car.setMaxSpeed(200);
        }
        return bean;
    }
}
