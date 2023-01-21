package com.testgenerator.testgenerator.model.flexmi_sequence;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.testgenerator.testgenerator.model.mxgraph.MxPoint;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

import java.util.List;

@Data
public class Operation {
    @JacksonXmlProperty(isAttribute=true)
    private String returnVariable;
    @JacksonXmlProperty(isAttribute=true)
    private String returnType;
    @JacksonXmlProperty(isAttribute=true)
    private String guardd;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Param> param;

}
