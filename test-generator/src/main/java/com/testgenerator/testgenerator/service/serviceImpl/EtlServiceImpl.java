package com.testgenerator.testgenerator.service.serviceImpl;

import com.testgenerator.testgenerator.service.EtlService;
import com.testgenerator.testgenerator.service.ModelLoadService;
import lombok.AllArgsConstructor;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
@Primary
@AllArgsConstructor
public class EtlServiceImpl implements EtlService {

    private ModelLoadService modelLoadService;
    @Override
    public EmfModel modelToModelTransformation(
            EmfModel sourceModel,
            String etlFileName,
            String targetMetaModel) throws Exception {

        EtlModule etlModule = new EtlModule();
        URI etlFile = Objects.requireNonNull(getClass().getResource("/etl/" + etlFileName)).toURI();

        EmfModel targetModel = modelLoadService.createNewModel(targetMetaModel, "Instance.model");

        etlModule.getContext().getModelRepository().addModel(sourceModel);
        etlModule.getContext().getModelRepository().addModel(targetModel);
        etlModule.parse(etlFile);
        etlModule.execute();

        return targetModel;
    }
}
