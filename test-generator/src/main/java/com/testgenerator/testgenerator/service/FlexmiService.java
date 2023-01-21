package com.testgenerator.testgenerator.service;

import com.testgenerator.testgenerator.model.flexmi_sequence.SequenceDiagram;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

public interface FlexmiService {
    SequenceDiagram parseMxGraph(InputStream stream) throws XMLStreamException, IOException;
    EmfModel flexmiToSequenceModel(String flexmi) throws EolModelLoadingException;
}
