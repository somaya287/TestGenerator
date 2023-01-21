package com.testgenerator.testgenerator.service.serviceImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.testgenerator.testgenerator.model.flexmi_sequence.Object;
import com.testgenerator.testgenerator.model.flexmi_sequence.*;
import com.testgenerator.testgenerator.model.mxgraph.MxCell;
import com.testgenerator.testgenerator.model.mxgraph.MxGraphModel;
import com.testgenerator.testgenerator.model.mxgraph.Root;
import com.testgenerator.testgenerator.service.FlexmiService;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class FlexmiServiceImpl implements FlexmiService {

    @Override
    public SequenceDiagram parseMxGraph(InputStream stream) throws XMLStreamException, IOException {
        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = f.createXMLStreamReader(stream);

        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        sr.next(); // to point to <root>
        sr.next(); // to point to root-element under root
        sr.next(); // to point to root-element under root
        sr.next(); // to point to root-element under root

        Map<String, Lifeline> map = new HashMap<>();
        MxGraphModel mxGraphModel = mapper.readValue(sr, MxGraphModel.class);
        Root root = mxGraphModel.getRoot();

        SequenceDiagram sequenceDiagram = new SequenceDiagram();
        sequenceDiagram.setName("SequenceDiagram");
        sequenceDiagram.setLifeline(new ArrayList<>());
        sequenceDiagram.setMessage(new ArrayList<>());

        // lifelines:
        for (MxCell mxCell : root.getMxCell()) {
            if (mxCell.getValue() == null) continue;
            if (mxCell.getValue().startsWith(":")) {

                Lifeline lifeline = new Lifeline();
                lifeline.setName(mxCell.getValue().replace(":", ""));

                Object object = new Object();
                object.setName(mxCell.getValue().replace(":", ""));
                lifeline.setObject(object);

                map.put(mxCell.getId(), lifeline);
                sequenceDiagram.getLifeline().add(lifeline);

            } else if (mxCell.getStyle().contains("umlActor")){

                Lifeline lifeline = new Lifeline();
                lifeline.setName(mxCell.getValue().replace(":", ""));

                Actor actor = new Actor();
                actor.setName(mxCell.getValue().replace(":", ""));
                lifeline.setActor(actor);

                map.put(mxCell.getId(), lifeline);
                sequenceDiagram.getLifeline().add(lifeline);
            } else if (mxCell.getValue().startsWith("[")) {

                // get type
                String messageFullName = mxCell.getValue().replace("[", "");
                String type = messageFullName.split("]")[0];
                messageFullName = messageFullName.split("]")[1];

                // get method name and parameters
                String methodName = messageFullName.split("\\(")[0];
                String[] parameters = messageFullName.split("\\(")[1].split(", ");
                parameters[parameters.length - 1] = parameters[parameters.length - 1].replace(")", "");
                Message message = new Message();

                // setting configuration
                message.setName(methodName);
                message.setType("Operation");
                message.setTarget(map.get(mxCell.getTarget()));
                message.setSource(map.get(mxCell.getSource()));

                // operation
                Operation operation = new Operation();
                operation.setGuardd("test");
                operation.setReturnType(type);
                operation.setReturnVariable(methodName + "ReturnVariable");
                operation.setParam(
                        Arrays.asList(parameters).stream()
                                .map(
                                        (String parameter) -> {
                                            Param param = new Param();
                                            param.setArgType(parameter.split(" ")[0]);
                                            param.setArgName(parameter.split(" ")[1]);
                                            return param;
                                        }
                                ).collect(Collectors.toList())
                );
                message.setOperation(operation);
                sequenceDiagram.getMessage().add(message);
            }
        }
        sr.close();

        return sequenceDiagram;
    }

    @Override
    public EmfModel flexmiToSequenceModel(String flexmi) throws EolModelLoadingException {

        EmfModel original = new EmfModel();
        original.setName("Source");
        original.setReadOnLoad(true);
        original.setStoredOnDisposal(false);
        original.setMetamodelFile(Objects.requireNonNull(getClass().getResource(flexmi)).getPath());
        original.setModelFile(Objects.requireNonNull(getClass().getResource("metaModels/sequenceMetaModel.ecore")).getPath());
        original.load();

        return original;
    }
}
