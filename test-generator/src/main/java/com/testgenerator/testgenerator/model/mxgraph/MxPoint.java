package com.testgenerator.testgenerator.model.mxgraph;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

@Data
public class MxPoint {
    @XmlAttribute
    private Float x;
    @XmlAttribute
    private Float y;
    @XmlAttribute
    private String as;
}
