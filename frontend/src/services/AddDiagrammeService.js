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
SetresultTest(res.data)
 
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};
/*
async function uploadFile() {
    let formData = new FormData(); 
    formData.append("file", fileupload.files[0]);
    let response = await fetch('/upload', {
      method: "POST", 
      body: formData
    }); 
  }
*/


export default AddDiagrammesService;