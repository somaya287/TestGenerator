package com.testgenerator.testgenerator.service;

import java.io.InputStream;

public interface TestGeneratorService {
    String generateTest(InputStream stream) throws Exception;
}
