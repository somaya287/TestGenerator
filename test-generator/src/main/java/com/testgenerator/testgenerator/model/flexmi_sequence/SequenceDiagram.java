package com.testgenerator.testgenerator.model.flexmi_sequence;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "sequenceDiagram")
public class SequenceDiagram {
    @JacksonXmlProperty(isAttribute=true, localName = "name")
    private String name;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Lifeline> lifeline;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Message> message;
}
