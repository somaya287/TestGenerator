package com.testgenerator.testgenerator.model.mxgraph;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

import java.util.List;

@Data
public class Array {
    @XmlAttribute
    private String as;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxPoint> mxPoint;
}
