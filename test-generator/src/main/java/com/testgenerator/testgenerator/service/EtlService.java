package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;

public interface EtlService {

    EmfModel modelToModelTransformation(EmfModel sourceModel,
                                        String etlFileName,
                                        String targetMetaModel) throws Exception;
}
