package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;

import java.net.URISyntaxException;

public interface EglService {

    String modelToTextTransformation(EmfModel sourceModel,
                                     String eglFileName,
                                     String sourceMetaModelFileName

    ) throws Exception;
}
