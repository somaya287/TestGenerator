package com.testgenerator.testgenerator.model.flexmi_sequence;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class Object {
    @JacksonXmlProperty(isAttribute=true)
    private String name;
}
