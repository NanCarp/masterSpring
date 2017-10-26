package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by nanca on 10/26/2017.
 */
public class FileResourceExample {

    public static void main(String[] args) {
        try {
            String filePath = "D:/";

            WritableResource res1 = new PathResource(filePath);

            Resource res2 = new ClassPathResource("conf/file1.txt");

            OutputStream stream1 = res1.getOutputStream();
            stream1.write("欢迎光临\n小春论坛".getBytes());
            stream1.close();

            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ((i = ins1.read()) != -1) {
                baos.write(i);
            }
            System.out.println(baos.toString());

            System.out.println("res:1" + res1.getFilename());
            System.out.println("res:2" + res2.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
