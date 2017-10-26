package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;


/**
 * Created by nanca on 10/26/2017.
 */
public class EncodeResourceExample {
    public static void main(String[] args) throws Throwable  {
        Resource res = new ClassPathResource("conf/file1.txt");
        EncodedResource encRes = new EncodedResource(res, "uTF_8");
        String content = FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);
    }
}
