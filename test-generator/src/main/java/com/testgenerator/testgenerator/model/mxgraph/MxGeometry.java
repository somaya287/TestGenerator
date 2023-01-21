package com.testgenerator.testgenerator.model.mxgraph;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class MxGeometry {
    @XmlAttribute
    private Float x;
    @XmlAttribute
    private Float y;
    @XmlAttribute
    private Float width;
    @XmlAttribute
    private Float height;
    @XmlAttribute
    private String as;
    @XmlAttribute
    private Integer relative;
    @XmlAttribute
    private MxPoint mxPoint;
    @XmlElement
    private Array array;

}
