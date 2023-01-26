package com.testgenerator.testgenerator.service;

import com.testgenerator.testgenerator.model.model_sequence.SequenceDiagram;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

public interface XmlService {
    SequenceDiagram parseMxGraph(InputStream stream) throws XMLStreamException, IOException;
}
