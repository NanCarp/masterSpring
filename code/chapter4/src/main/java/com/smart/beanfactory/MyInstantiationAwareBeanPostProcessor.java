package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by nanca on 10/30/2017.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public Object PostProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor, postProcess BeforeInstantiation");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor, postProcess AfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName
    ) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("Instantiation AwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
