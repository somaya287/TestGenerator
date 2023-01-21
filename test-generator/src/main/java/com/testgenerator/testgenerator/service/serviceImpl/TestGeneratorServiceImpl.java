package com.testgenerator.testgenerator.service.serviceImpl;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.testgenerator.testgenerator.model.flexmi_sequence.SequenceDiagram;
import com.testgenerator.testgenerator.service.*;
import lombok.AllArgsConstructor;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
@Primary
@AllArgsConstructor
public class TestGeneratorServiceImpl implements TestGeneratorService {

    private EtlService etlService;
    private EglService eglService;
    private EvlService evlService;
    private FlexmiService flexmiService;
    private ModelLoadService modelLoadService;

    @Override
    public String generateTest(InputStream stream) throws Exception {

        XmlMapper mapper = new XmlMapper();
        FlexmiService flexmiService = new FlexmiServiceImpl();

        // generate flexmi from mxGraph
        SequenceDiagram sequenceDiagram = flexmiService.parseMxGraph(stream);

        // save the flexmi file
        OutputStream outputStream = new FileOutputStream("/Users/gh.maymoun/Documents/Projects/MDE/MDEproject/test-generator/src/main/resources/flexmi.xml");
        outputStream.write("<?nsuri psl?>\n".getBytes());
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        outputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
        XMLStreamWriter xmlStreamWriter = outputFactory.createXMLStreamWriter(outputStream);

        mapper.writeValue(xmlStreamWriter, sequenceDiagram);
        xmlStreamWriter.close();

        // load the sequence model
        EmfModel sequenceModel = modelLoadService.createNewModel("flexmi.xml", "sequenceMetaModel.ecore");

        // validate the sequence model
        evlService.validateModel(sequenceModel, "sequenceModel.evl");

        // transform the sequence model to the abstract test model:
        EmfModel abstractTestModel = etlService.modelToModelTransformation(sequenceModel, "sequenceModelToAbstractTest.etl", "abstractTestMetaModel.ecore");

        // validate the abstract test model;
        evlService.validateModel(abstractTestModel, "abstractTestModel.evl");

        // transform the Abstract test model to the java test model:
        EmfModel javaTestModel = etlService.modelToModelTransformation(abstractTestModel, "abstractTestToJavaTestTransformation.etl", "javaTestMetaModel.ecore");

        // validate the java test model;
        evlService.validateModel(javaTestModel, "javaTestMetaModel.evl");

        // generate test code :
        eglService.modelToTextTransformation(javaTestModel, "")
    }
}
