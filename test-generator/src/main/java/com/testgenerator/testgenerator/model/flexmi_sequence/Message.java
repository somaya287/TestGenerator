package com.testgenerator.testgenerator.model.flexmi_sequence;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class Message {
    @JacksonXmlProperty(isAttribute=true)
    private String name;
    @JacksonXmlProperty(isAttribute=true)
    private String type;
    @XmlElement
    private Operation operation;
    @XmlElement
    private Lifeline target;
    @XmlElement
    private Lifeline source;
}
