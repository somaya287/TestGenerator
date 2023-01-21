package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;

public interface EvlService {
    void validateModel(EmfModel model, String evlFileName) throws Exception;
}
