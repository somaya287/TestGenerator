package com.testgenerator.testgenerator.service.serviceImpl;
import com.testgenerator.testgenerator.service.ModelLoadService;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

@Service
@Primary
public class ModelLoadServiceImpl implements ModelLoadService {
    @Override
    public EmfModel createNewModel(String metaModelFileName, String modelName) throws EolModelLoadingException, URISyntaxException {
        EmfModel model = new EmfModel();
        model.setMetamodelFile(
                Objects.requireNonNull(
                        getClass().getResource("/metaModels/" + metaModelFileName)
                ).toURI().getPath()
        );
        model.setModelFile(
                "/Users/gh.maymoun/Documents/Projects/MDE/MDEproject/test-generator/src/main/resources/models/" +
                        modelName + ".model"
        );
        model.setReadOnLoad(false);
        model.setStoredOnDisposal(false);
        model.setName(modelName);
        model.load();
        return model;
    }

    @Override
    public EmfModel readModel(String modelName) throws EolModelLoadingException, IOException {

        EmfModel model = new EmfModel();
        model.setName("SequenceModel");
        model.setReadOnLoad(true);
        model.setStoredOnDisposal(false);
        model.setMetamodelFile(
                Objects.requireNonNull(
                        getClass().getResource("/metaModels/sequenceMetaModel.ecore")
                ).getPath()
        );
        model.setModelFile(
                Objects.requireNonNull(
                        getClass().getResource("/models/" + modelName)
                ).getPath()
        );
        model.load();
        System.out.println(model.getAliases());
        return model;
    }
}
