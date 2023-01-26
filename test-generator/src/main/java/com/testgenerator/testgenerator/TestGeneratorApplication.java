package com.testgenerator.testgenerator;

import com.testgenerator.testgenerator.service.serviceImpl.EtlServiceImpl;
import com.testgenerator.testgenerator.service.serviceImpl.ModelLoadServiceImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class TestGeneratorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestGeneratorApplication.class, args);
        /*
        EtlServiceImpl etlService = new EtlServiceImpl(new ModelLoadServiceImpl());
        EmfModel model = new EmfModel();
        model.setName("AbstractTestModel");
        model.setReadOnLoad(true);
        model.setStoredOnDisposal(false);
        model.setMetamodelFile(
                Objects.requireNonNull(
                        TestGeneratorApplication.class.getResource("/metaModels/abstractTestMetaModel.ecore")
                ).getPath()
        );
        model.setModelFile(
                Objects.requireNonNull(
                        TestGeneratorApplication.class.getResource("/models/abstract.model")
                ).getPath()
        );
        model.load();

        etlService.modelToModelTransformation(model, "abstractTestToJavaTestTransformation.etl", "JavaTestModel", "javaTestMetaModel.ecore");

         */
    }


}
