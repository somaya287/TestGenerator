package com.testgenerator.testgenerator.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

@Slf4j
@RestController
@RequestMapping("/")
public class ReceiveXML {

    @PostMapping("/1")
    public void handleXMLStream(@RequestBody InputStream stream) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(stream);
            // your code to handle the XML document
        } catch (Exception e) {
            // handle exception
        }
    }
    @PostMapping("/2")
    public void handleXMLFile(@RequestParam("file") MultipartFile file) {
        // your code to handle the XML file
    }

}
