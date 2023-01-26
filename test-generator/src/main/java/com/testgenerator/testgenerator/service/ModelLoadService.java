package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ModelLoadService {
    EmfModel createNewModel(String metaModelFileName, String modelName) throws EolModelLoadingException, URISyntaxException;
    EmfModel readModel(String model) throws EolModelLoadingException, IOException;
}
