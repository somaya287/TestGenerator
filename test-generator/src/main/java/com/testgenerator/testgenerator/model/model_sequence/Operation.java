package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "operationn")
@JsonPropertyOrder(value = {"id", "returnVariable", "returnType"})
public class Operation {
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute=true, localName = "returnVariable")
    private String returnVariable;
    @JacksonXmlProperty(isAttribute=true, localName = "returnType")
    private String returnType;
    @JacksonXmlProperty(isAttribute=true, localName = "guardd")
    private String guard;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Param> param;

}
