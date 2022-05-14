package com.jmu.XPathDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XpathDemoApplication {

    public static void main(String[] args) {
        System.setProperty("jdk.xml.entityExpansionLimit", "100000");
        SpringApplication.run(XpathDemoApplication.class, args);
    }

}
