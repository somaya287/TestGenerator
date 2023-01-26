package com.testgenerator.testgenerator.service.serviceImpl;

import com.testgenerator.testgenerator.service.EtlService;
import com.testgenerator.testgenerator.service.ModelLoadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
@Primary
@AllArgsConstructor
@Slf4j
public class EtlServiceImpl implements EtlService {

    private ModelLoadService modelLoadService;
    @Override
    public EmfModel modelToModelTransformation(
            EmfModel sourceModel,
            String etlFileName,
            String targetModelName,
            String targetMetaModel) throws Exception {

        EmfModel targetModel = modelLoadService.createNewModel(targetMetaModel, targetModelName);
        targetModel.setName(targetModelName);

        EtlModule etlModule = new EtlModule(new EtlContext());
        URI etlFile = Objects.requireNonNull(getClass().getResource("/etl/" + etlFileName)).toURI();

        etlModule.getContext().getModelRepository().addModel(targetModel);
        etlModule.getContext().getModelRepository().addModel(sourceModel);

        log.info(etlModule.getContext().getModelRepository().getModels().toString());
        etlModule.parse(etlFile);
        etlModule.execute();

        sourceModel.dispose();
        return targetModel;
    }
}
