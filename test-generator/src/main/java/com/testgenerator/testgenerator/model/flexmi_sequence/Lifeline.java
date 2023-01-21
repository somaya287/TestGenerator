package com.testgenerator.testgenerator.model.flexmi_sequence;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data

public class Lifeline {
    @JacksonXmlProperty(isAttribute=true)
    private String name;
    @JacksonXmlProperty(isAttribute=true)
    private Boolean start;
    @XmlElement
    private Object object;
    @XmlElement
    private Actor actor;
}
