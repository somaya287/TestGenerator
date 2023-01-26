<h1 style="text-align: center;"> <img src="readme/Logo.png" alt="logo" width="30"/> Test Generator </h1>

<p style="text-align: center;"> A web application that generates <b>integration test code</b> in Java based on an uploaded <b>activity/sequence diagram</b> </p><br/>
<p style="text-align: center;"> <b>Application Link :</b> <i>http://167.172.141.190:3000</i> </p>

## 📝 Description 
Since both sequence and activity diagrams provide a clear and detailed representation of the behaviour of a system, we can generate integration tests based on them. Thus the programmer can delve directly into coding while adhering to the Test Driven Development concepts.
 
## 📺 Demo
<video controls="controls">
    <source src="readme/demo.mp4" type="video/mp4">
</video>

## ⏩ Workflow 
To achieve the objective of the project, we implemented the following modeling workflow :
![workflow](/readme/workflow.png)
*MDD workflow*

## 👉 Metamodels
### Sequence diagram
- ### Sequence diagram Metamodel 
    ![seqMM](/readme/seq.png)

- ### Validation in OCL 
    ``` python
    context SequenceDiagram
    inv : self.name.isMatch("^[a-z][A-Za-z0-9_]*$" and self.name.size() > 0 and self.lifelines.size()>0

    context LifeLine
    inv : self.name.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$") and self.abstractObjects.size()>0

    context AbstractObject
    inv : self.name.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$") 

    context CombinedFragment
    inv : self.name.isMatch("^[a-z][A-Za-z0-9_]*$" and self.name.size() > 0  and self.interactionOperator.IsOCLKindOf       (MessageKind)

    context InteractionOperand
    inv : self.guard.isMatch("^[a-z][A-Za-z0-9_]*$" and self.guard.size() > 0 

    context Message
    inv : self.name.isMatch("^[a-z][A-Za-z0-9_]*$" and self.name.size() > 0 and self.type.IsOCLKindOf(MessageKind) and self.source <> null and self.target <> null

    context Operation
    inv :  self.returnVariable.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$") self.returnType.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$") and self.guard.size() > 0 and self.guard.isMatch("[A-Za-z0-9_]*$") and

    context Param
    inv : self.argName.size() > 0 and self.argName.isMatch("[A-Za-z0-9_]*$") and self.argType.size() > 0 and self.argType.isMatch("[A-Za-z0-9_]*$")
    ```

### Activity diagram 
- ### Activity diagram Metamodel 
    ![activityMM](/readme/activity.png)

- ### Validation in OCL 
    ``` python
    context ActivityDiagram
    inv: self.activities.includes(self.initial) and self.name.isMatch("[a-z0-9_A-Z ]*$") and self.name.size() > 0 

    context Start
    inv: self.outGoingEdges.size() > 0 and self.inGoingEdges.size() == 0

    context End
    inv: self.inGoingEdges.size() > 0 and self.outGoingEdges.size() == 0

    context Decision
    inv: self.outGoingEdges.size() >= 2 and self.outGoingEdges.size() == self.close.inGoingEdges.size() and self.inGoingEdges.size() == 1

    context Merge
    inv: self.inGoingEdges.size() >= 2; self.inGoingEdges.size() == self.close.outGoingEdges.size() and self.outGoingEdges.size() == 1

    context Fork
    inv: self.outGoingEdges.size() >= 2 and self.outGoingEdges.size() == self.close.inGoingEdges.size()

    context Join
    inv: self.inGoingEdges.size() >= 2 and self.inGoingEdges.size() == self.close.outGoingEdges.size()

    context Edge
    inv : self.src != self.dest
    ```

### Abstract Tests 
- ### Abstract Test Metamodel 
    ![abstractMM](/readme/abstract.png)

- ### Validation in OCL 
    ``` python
    context Test
    inv : self.testClass.exists() and self.testClass.methods.notEmpty()

    context Class 
    inv : self.name.size() > 0 and self.name.isMatch("^[A-Z][a-zA-Z0-9]*$")

    context Method 
    inv : self.name.size() > 0 and self.name.isMatch("[a-z][A-Za-z0-9_]*$")

    context Variable 
    inv : self.name.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$")
    ```

### Java tests 
- ### Java Test Metamodel 
    ![javaMM](/readme/javatest.png)

- ### Validation in OCL 
    ``` python
    context TestPackage
    inv : self.name.isMatch("^[a-z][a-z0-9_]*$") and self.name.size() > 0 

    context TestFile
    inv : self.name.size() > 0 and self.name.isMatch("^[A-Z][a-zA-Z0-9]*Test$") and 
                    self.testClass.name = self.name	

    context Method
    inv : self.name.isMatch("^test[A-Z][A-Za-z0-9_]*$" and self.name.size() > 0 

    context TestAnnotation
    inv : self.expectedExceptions.forAll(s | s.isMatch("^[A-Z][a-zA-Z0-9]*Exception$"))

    context AssertInstruction 
    inv : self.assertionType.isMatch("^assert[a-zA-Z]*$")

    context ImportedClass 
    inv : self.name.size() > 0 and self.name.isMatch("^[A-Z][a-zA-Z0-9]*$")

    context Method, ImportedMethod
    inv : self.name.isMatch("^[a-z][A-Za-z0-9_]*$" and self.name.size() > 0 

    context Variable 
    inv : self.name.size() > 0 and self.name.isMatch("[A-Za-z0-9_]*$")
    ```

## 🔧 Technical architecture

![tech](/readme/tech.png)

## 🚀 How to use the project ? 
1. Export your sequence/activity diagram made in [drawio](https://app.diagrams.net/) in the XML format
2. Unselect compressed and then click on export 
3. Acces the following link : [Link to our app](https://app.diagrams.net/)
4. Upload your xml file in our UI 
5. Click on Generate Tests

Aaand, the result will be shown there !

## 🤝 Code contributors 
This project was done thanks to : 

<a>
  <img src="https://contrib.rocks/image?repo=somaya287/TestGenerator" />
</a>


## 🔗 Usefull links 
[Epsilon Documentation](https://www.eclipse.org/epsilon/doc/)
