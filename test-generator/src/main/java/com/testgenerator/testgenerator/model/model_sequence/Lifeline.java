package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@JsonPropertyOrder(value = {"id", "name", "start"})
public class Lifeline {
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute=true, localName = "name")
    private String name;
    @JacksonXmlProperty(isAttribute=true, localName = "start")
    private String start;
    @XmlElement
    @JacksonXmlProperty(localName = "abstractObject")
    private AbstractObject abstractObject;
}
