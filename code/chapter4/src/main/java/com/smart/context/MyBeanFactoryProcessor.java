package com.smart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by nanca on 10/31/2017.
 */
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {


    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        BeanDefinition bd = bf.getBeanDefinition("car");

        bd.getPropertyValues().addPropertyValue("brand", "qq");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()!");
    }
}
