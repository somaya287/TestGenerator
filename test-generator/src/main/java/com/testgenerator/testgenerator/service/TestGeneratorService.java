package com.testgenerator.testgenerator.service;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

public interface TestGeneratorService {
    String generateTest(InputStream stream) throws Exception;
}
