package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;

public interface ModelLoadService {
    EmfModel createNewModel(String metaModelFileName, String modelName);
}
