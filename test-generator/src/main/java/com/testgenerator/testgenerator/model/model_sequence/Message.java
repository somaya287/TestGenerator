package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@JsonPropertyOrder(value = {"type", "id", "target", "source", "name"})
@JacksonXmlRootElement(localName = "fragments")
public class Message {
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.w3.org/2001/XMLSchema-instance", localName = "type")
    private String type;
    @JacksonXmlProperty(isAttribute=true, localName = "name")
    private String name;
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "id")
    private String id;
    @XmlElement
    private Operation operationn;
    @JacksonXmlProperty(isAttribute=true, localName = "target")
    private String target;
    @JacksonXmlProperty(isAttribute=true, localName = "source")
    private String source;

    {
        this.type = "sequenceMetaModel:Message";
    }
}
