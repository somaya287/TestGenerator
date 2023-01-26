package com.testgenerator.testgenerator.model.model_sequence;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "sequenceMetaModel:SequenceDiagram")
@JsonPropertyOrder(value = {"version", "xmi", "xsi", "sequenceMetaModel", "id", "name", "empty"})
public class SequenceDiagram {
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "version")
    private String version;
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.omg.org/XMI", localName = "id")
    private String id;
    @JacksonXmlProperty(isAttribute=true, localName = "name")
    private String name;
    @JacksonXmlElementWrapper(useWrapping = false, localName = "lifeLines")
    private List<Lifeline> lifeLines;
    @JacksonXmlElementWrapper(useWrapping = false, localName = "fragments")
    private List<Message> fragments;
    @JacksonXmlProperty(isAttribute=true, namespace = "http://www.w3.org/2001/XMLSchema-instance", localName = "empty1")
    private String empty1;
    @JacksonXmlProperty(isAttribute=true, namespace = "sequenceMetaModel", localName = "empty2")
    private String empty2;

    {
        this.version = "2.0";
        this.empty1 = "";
        this.empty2 = "";
    }
}
