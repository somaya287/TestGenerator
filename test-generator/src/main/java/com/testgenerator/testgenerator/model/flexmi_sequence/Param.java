package com.testgenerator.testgenerator.model.flexmi_sequence;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

@Data
public class Param {
    @XmlAttribute
    private String argName;
    @XmlAttribute
    private String argType;
}
