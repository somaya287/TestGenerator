package com.testgenerator.testgenerator.service.serviceImpl;

import com.testgenerator.testgenerator.service.EglService;
import lombok.AllArgsConstructor;
import org.eclipse.epsilon.egl.internal.EglModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
@Primary
@AllArgsConstructor
public class EglServiceImpl implements EglService {

    @Override
    public String modelToTextTransformation(EmfModel sourceModel,
                                            String eglFileName,
                                            String sourceMetaModelFileName) throws Exception {
        EglModule eglModule = new EglModule();
        URI eglFile = Objects.requireNonNull(getClass().getResource("/egl/" + eglFileName)).toURI();

        eglModule.getContext().getModelRepository().addModel(sourceModel);
        eglModule.parse(eglFile);

        return (String)eglModule.execute();
    }
}
