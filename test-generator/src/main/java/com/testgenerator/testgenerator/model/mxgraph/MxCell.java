package com.testgenerator.testgenerator.model.mxgraph;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import lombok.Data;

@Data
public class MxCell {

    @XmlID
    private String id;
    @XmlAttribute
    private String parent;
    @XmlAttribute
    private Integer vertex;
    @XmlAttribute
    private Integer edge;
    @XmlAttribute
    private String source;
    @XmlAttribute
    private String target;
    private String style;
    @XmlAttribute
    private Integer connectable;
    @XmlAttribute
    private String value;
    private MxGeometry mxGeometry;
}
