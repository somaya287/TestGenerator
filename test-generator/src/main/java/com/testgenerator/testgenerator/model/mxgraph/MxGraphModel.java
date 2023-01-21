package com.testgenerator.testgenerator.model.mxgraph;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "mxGraphModel")
public class MxGraphModel {
    @XmlElement(name = "root")
    private Root root;
}
