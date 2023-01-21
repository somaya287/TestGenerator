package com.testgenerator.testgenerator.service.serviceImpl;

import com.testgenerator.testgenerator.service.EvlService;
import lombok.AllArgsConstructor;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
@Primary
@AllArgsConstructor
    public class EvlServiceImpl implements EvlService {

    @Override
    public void validateModel(EmfModel model, String evlFileName) throws Exception {
        EvlModule evlModule = new EvlModule();
        URI evlFile = Objects.requireNonNull(getClass().getResource("/evl/" + evlFileName)).toURI();
        evlModule.parse(evlFile);
        evlModule.getContext().getModelRepository().addModel(model);
        evlModule.execute();
    }
}
