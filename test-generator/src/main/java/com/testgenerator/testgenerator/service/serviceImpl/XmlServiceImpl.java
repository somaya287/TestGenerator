package com.testgenerator.testgenerator.service.serviceImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.testgenerator.testgenerator.model.model_sequence.Object;
import com.testgenerator.testgenerator.model.model_sequence.*;
import com.testgenerator.testgenerator.model.mxgraph.MxCell;
import com.testgenerator.testgenerator.model.mxgraph.MxGraphModel;
import com.testgenerator.testgenerator.model.mxgraph.Root;
import com.testgenerator.testgenerator.service.XmlService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Primary
public class XmlServiceImpl implements XmlService {

    private String diagramId;

    @Override
    public SequenceDiagram parseMxGraph(InputStream stream) throws XMLStreamException, IOException {

        // get the MxGraphModel from the stream:
        MxGraphModel mxGraphModel = this.extractMxGraphModel(stream);

        // jump to root element
        Root root = mxGraphModel.getRoot();

        // initialize the new elements to write in the model's xml
        SequenceDiagram sequenceDiagram = new SequenceDiagram();
        sequenceDiagram.setName("SequenceDiagram");
        sequenceDiagram.setLifeLines(new ArrayList<>());
        sequenceDiagram.setFragments(new ArrayList<>());

        String actorId = null;

        for (MxCell mxCell : root.getMxCell()) {

            // if the current cell has no value then we just ignore it
            // as it will not give us any information we could use in the test generation
            if (mxCell.getValue() == null) continue;

            // now starting with the lifelines:
            if (mxCell.getValue().startsWith(":")) {

                // excluding the actor, all lifeline names start with ":", so when we detect it we extract a lifeline.
                Lifeline lifeline = this.parseMxCellToLifeline(mxCell);

                // next we add the lifeline in the sequence diagram.
                sequenceDiagram.getLifeLines().add(lifeline);

            } else if (mxCell.getStyle().contains("umlActor")){

                // the actor is a special type of lifelines, it does not have ":" in its name,
                // but it has the word "umlActor" in its style
                Lifeline lifeline = this.parseMxCellToActor(mxCell);

                sequenceDiagram.getLifeLines().add(lifeline);
                actorId = lifeline.getId();

            } else if (mxCell.getValue().startsWith("[")) {

                // until now, the only type of messages we deal with is operation.
                // the operations are in short functions, with parameters and return types.
                // their format is: [returnType]operationName(parameterType parametersName, ....)
                String messageExpression = mxCell.getValue();

                // get return type :
                String returnType = this.extractOperationsReturnType(messageExpression);

                // get methods name
                String methodName = this.extractOperationsName(messageExpression);

                // get parameters
                String[] parameters = this.extractOperationsParameters(messageExpression);

                // now starting on generating messages:
                Message message = new Message();

                message.setId("message_" + mxCell.getId());
                message.setName(methodName);
                message.setTarget("lifeline_" + mxCell.getTarget());
                message.setSource("lifeline_" + mxCell.getSource());

                // the message is of operation type, so it will have an operation object inside of it
                Operation operation = new Operation();
                operation.setId("operation_" + mxCell.getId());
                operation.setGuard("test");
                operation.setReturnType(returnType);
                operation.setReturnVariable(methodName + "ReturnVariable");
                operation.setParam(
                        Arrays.stream(parameters)
                                .map(
                                        (String parameter) -> {
                                            Param param = new Param();
                                            param.setId("param_" + mxCell.getId() + "_" + (int)(Math.random() * 1000));
                                            // as we have extracted the parameters as a texts,
                                            // we have to split them to type and name.
                                            param.setArgType(parameter.split(" ")[0]);
                                            param.setArgName(parameter.split(" ")[1]);
                                            return param;
                                        }
                                ).collect(Collectors.toList())
                );
                message.setOperationn(operation);

                // lastly we add the message to the sequence diagram
                sequenceDiagram.getFragments().add(message);
            }
        }
        sequenceDiagram.setId(this.diagramId);

        // find the start lifeline
        String startId = null;

        for (Message message : sequenceDiagram.getFragments()) {
            if (message.getSource().equals(actorId)) {
                startId = message.getTarget();
                break;
            }
        }

        for (Lifeline lifeline : sequenceDiagram.getLifeLines()) {
            if (lifeline.getId().equals(startId))
                lifeline.setStart("true");
        }

        return sequenceDiagram;
    }

    public MxGraphModel extractMxGraphModel(InputStream stream) throws XMLStreamException, IOException {

        // create the mapper
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // create xml stream reader
        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = f.createXMLStreamReader(stream);

        // point to the Sequence diagram root
        sr.next(); // to point to the xml prefix
        sr.next(); // to point to mxfile element
        sr.next(); // to point to diagram element
        // we will get the id of the diagram and associate it to the MxGraphModel
        this.diagramId = sr.getAttributeValue(1);
        sr.next(); // to point to the sequence diagram// element

        // read xml elements
        MxGraphModel mxGraphModel = mapper.readValue(sr, MxGraphModel.class);

        // close the mapper
        sr.close();

        return mxGraphModel;
    }

    public Lifeline parseMxCellToLifeline(MxCell mxCell) {

        Lifeline lifeline = new Lifeline();
        lifeline.setId("lifeline_" + mxCell.getId());
        // first we get the pure name of the lifeline by deleting the ":".
        String lifeLineName = mxCell.getValue().replace(":", "");
        lifeline.setName(lifeLineName);

        // each lifeline will have an object inside of it with the same name
        Object object = new Object();
        object.setId("object_" + mxCell.getId());
        object.setName(lifeLineName);
        lifeline.setAbstractObject(object);

        return lifeline;
    }

    public Lifeline parseMxCellToActor(MxCell mxCell) {

        Lifeline lifeline = new Lifeline();
        lifeline.setId("lifeline_" + mxCell.getId());
        lifeline.setName(mxCell.getValue());

        // each actor lifeline will have an actor object inside of it with the same name.
        Actor actor = new Actor();
        lifeline.setId("lifeline_" + mxCell.getId());
        actor.setName(mxCell.getValue());
        lifeline.setAbstractObject(actor);
        return lifeline;
    }

    public String extractOperationsReturnType(String messageExpression) {
        return messageExpression
                .replace("[", "")
                .split("]")[0];
    }

    public String extractOperationsName(String messageExpression) {
        return messageExpression
                .replace("[", "")
                .split("]")[1]
                .split("\\(")[0];
    }

    public String[] extractOperationsParameters(String messageExpression) {
        String[] parameters = messageExpression
                .replace("[", "")
                .split("]")[1]
                .split("\\(")[1]
                .split(", ");

        parameters[parameters.length - 1] = parameters[parameters.length - 1].replace(")", "");

        return parameters;
    }

}
