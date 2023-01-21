import axios from "axios";

const AddDiagrammesService = (data,Diagramme,SetresultTest) => {
    const dataToSend = {
        type: {Diagramme},
        file: data.get('fie'),
        
    }
    console.log("data");
    console.log(dataToSend);
    axios.post(`urltochange`, dataToSend, {
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(
        (res) => {
            SetresultTest(res.data)
console.log(res);
          
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};




export default AddDiagrammesService;