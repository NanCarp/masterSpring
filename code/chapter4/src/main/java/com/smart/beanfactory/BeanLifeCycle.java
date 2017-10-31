package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by nanca on 10/31/2017.
 */
public class BeanLifeCycle {
    public static void LifeCycleInBeanFactory() {
        Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");

        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
        reader.loadBeanDefinitions(res);

        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        Car car2 = (Car) bf.getBean("car");

        System.out.println("car1==car2:" + (car1 == car2));

        ((ConfigurableBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
