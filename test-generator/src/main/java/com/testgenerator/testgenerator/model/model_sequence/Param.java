package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonPropertyOrder(value = {"id", "argName", "argType"})
public class Param {
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute=true, localName = "argName")
    private String argName;
    @JacksonXmlProperty(isAttribute=true, localName = "argType")
    private String argType;
}
