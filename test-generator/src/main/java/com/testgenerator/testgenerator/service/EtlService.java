package com.testgenerator.testgenerator.service;

import org.eclipse.epsilon.emc.emf.EmfModel;

public interface EtlService {

    EmfModel modelToModelTransformation(EmfModel sourceModel,
                                        String etlFileName,
                                        String targetModelName,
                                        String targetMetaModel) throws Exception;
}
