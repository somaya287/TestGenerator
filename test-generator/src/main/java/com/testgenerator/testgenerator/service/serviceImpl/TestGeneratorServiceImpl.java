package com.testgenerator.testgenerator.service.serviceImpl;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.testgenerator.testgenerator.model.model_sequence.SequenceDiagram;
import com.testgenerator.testgenerator.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
@Primary
@AllArgsConstructor
@Slf4j
public class TestGeneratorServiceImpl implements TestGeneratorService {

    private EtlService etlService;
    private EglService eglService;
    private EvlService evlService;
    private XmlService xmlService;
    private ModelLoadService modelLoadService;

    @Override
    public String generateTest(InputStream stream) throws Exception {

        XmlMapper mapper = new XmlMapper();

        // first we parse the mxGraph and extract the sequence diagram.
        SequenceDiagram sequenceDiagram = xmlService.parseMxGraph(stream);

        // next we should write the models xml to a string first in order to fix the namespace prefixes.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("<?xml version=\"1.0\" encoding=\"ASCII\"?>".getBytes());

        // create a xml stream writer
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        outputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
        XMLStreamWriter xmlStreamWriter = outputFactory.createXMLStreamWriter(outputStream);

        mapper.writeValue(xmlStreamWriter, sequenceDiagram);
        xmlStreamWriter.close();

        String xmlOutput = outputStream.toString(StandardCharsets.UTF_8);
        xmlOutput = xmlOutput.replace("wstxns2", "xsi");
        xmlOutput = xmlOutput.replace("wstxns1", "xmi");
        xmlOutput = xmlOutput.replace("wstxns3", "sequenceMetaModel");
        xmlOutput = xmlOutput.replace("xsi:empty1=\"\"", "");
        xmlOutput = xmlOutput.replace("sequenceMetaModel:empty2=\"\"", "");

        // now we write to the file:
        OutputStream fileOutputStream = new FileOutputStream(
                "C:\\Users\\Somaya\\MDEproject\\test-generator\\src\\main\\resources\\models\\sequence.model"
        );

        fileOutputStream.write(xmlOutput.getBytes());
        fileOutputStream.close();

        // load the sequence model
        EmfModel sequenceModel = modelLoadService.readModel("sequence.model");

        log.info(sequenceModel.getName());

        // validate the sequence model
        evlService.validateModel(sequenceModel, "sequenceModel.evl");

        // transform the sequence model to the abstract test model:
        EmfModel abstractTestModel = etlService.modelToModelTransformation(sequenceModel, "sequenceModelToAbstractTest.etl", "AbstractTestModel", "abstractTestMetaModel.ecore");

        // validate the abstract test model;
        evlService.validateModel(abstractTestModel, "abstractTestModel.evl");

        // transform the Abstract test model to the java test model:
        EmfModel javaTestModel = etlService.modelToModelTransformation(abstractTestModel, "abstractTestToJavaTestTransformation.etl", "JavaTestModel", "javaTestMetaModel.ecore");

        // validate the java test model;
        evlService.validateModel(javaTestModel, "javaTestMetaModel.evl");

        // generate test code :
        return eglService.modelToTextTransformation(javaTestModel, "testFile2File.egl", "javaTestMetaModel.ecore");
    }
}
