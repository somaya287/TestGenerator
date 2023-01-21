package com.testgenerator.testgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@SpringBootApplication
public class TestGeneratorApplication {

    public static void main(String[] args) throws XMLStreamException, IOException {
        SpringApplication.run(TestGeneratorApplication.class, args);
    }

}
