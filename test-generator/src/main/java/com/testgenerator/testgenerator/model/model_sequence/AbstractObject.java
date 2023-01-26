package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonPropertyOrder(value = {"type", "id", "name"})
public class AbstractObject {
    @JacksonXmlProperty(isAttribute=true, localName = "id", namespace = "http://www.omg.org/XMI")
    private String id;
    @JacksonXmlProperty(isAttribute=true, localName = "name")
    protected String name;
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.w3.org/2001/XMLSchema-instance", localName = "type")
    protected String type;
}
