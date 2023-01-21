package com.testgenerator.testgenerator.model.mxgraph;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Root {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxCell> mxCell;
}
