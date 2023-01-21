package com.testgenerator.testgenerator.service.serviceImpl;

import com.testgenerator.testgenerator.service.ModelLoadService;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Primary
public class ModelLoadServiceImpl implements ModelLoadService {
    @Override
    public EmfModel createNewModel(String metaModelFileName, String modelName) {
        EmfModel model = new EmfModel();
        model.setMetamodelFile(
                Objects.requireNonNull(
                        getClass().getResource("/motaModels/" + modelName)
                ).getPath()
        );
        model.setName(modelName);
        return model;
    }
}
