import React from 'react'
import CodeTextEditor from './CodeTextEditor';
import Title from "./Title"
import Grid from '@mui/material/Grid';
import DownloadButton from './DownloadButton';
import GenerateButton from './GenerateButton';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import AddDiagrammesService from "../services/AddDiagrammeService"
import {Stack} from "@mui/material"
import CodeEditor, { SelectionText } from "@uiw/react-textarea-code-editor";
import './style.css'
import DownloadIcon from '@mui/icons-material/Download';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

import Button from '@mui/material/Button';
export default function Home ()  {
  const [diagramme, setDiagramme] = React.useState('');
  const [resultTest, SetresultTest] = React.useState('');
  const [code, setCode] = React.useState(
    `function add(a, b) {\n  return a + b;\n}`
  );
  
  const handleChange = e => {
    setDiagramme(e.target.value);
    
};
const styles = theme => ({

    notchedOutline: {
      borderWidth: "1px",
      borderColor: "yellow !important"
    }
  });


  
  const TextFile = () => {
    const element = document.createElement("a");
    const file = new Blob([document.getElementById('test').value], {type: 'text/plain'});
    element.href = URL.createObjectURL(file);
    element.download = "Test.java";
    document.body.appendChild(element); // Required for this to work in FireFox
    element.click();
  }
  
  const handleSubmit = (event) => {

    AddDiagrammesService (event,diagramme,SetresultTest)
};

    return(
        <Grid
        container
        direction="column"
        justifyContent="space-between"
        alignItems="stretch"
      >
        <Grid item xs={12}>

        <div>
            <img  className="imgz" src="./Logo.png" />

    <p className="text">TEST GENERATOR</p> 

    <Box sx={{ minWidth: 120 }} onSubmit={handleSubmit}>
    <label className='txtField1' style={{color:"white"}}for="standard-select">Select Diagram type</label>

   <select  onChange={handleChange} 
 className='txtField' name="Diagramme" id="Diagramme"  >
            <option value="Diagramme de Séquence" style={{color:"white"}} selected>Diagramme de Séquence</option>
            <option value="Diagramme de Séquence">Diagramme d'activité</option>
           

    </select>

    <label  className='txtField2' style={{color:"white"}}for="standard-select">Upload your Diagram(.xml)</label>

        <input id="file" className='txtinpt' type="file" name="country"  placeholder="Select Diagram type"  ></input>
        <Grid item xs={12} style={{marginTop:"600px"}}>
    <div>
            <button type="submit" className='button' onClick={() => console.log('click')}>
                <div className='button-text'>GENERATE TESTS</div>
                <div className='button-icon'><ArrowForwardIcon/></div>
            </button>
        </div>

    </Grid>
    </Box>
  
   
    </div>
    </Grid>

 
    <Grid item xs={12}
  container
  direction="row"
  justifyContent="center"
  alignItems="stretch"
>

    <Grid xs={1}></Grid>
    <Grid item xs={8} style={{marginTop:"30px"}}>
    <div >
        <CodeEditor id="test"
          value={code}
          language="js"
          placeholder="Please enter JS code."
          onChange={(evn) => setCode(evn.target.value)}
          padding={15}
          style={{
            fontFamily:
              "ui-monospace,SFMono-Regular,SF Mono,Consolas,Liberation Mono,Menlo,monospace",
              backgroundColor: "#F0F0EB",
            fontSize: 12
          }}
        />
        </div>

    </Grid>
    <Grid xs={1}></Grid>
        </Grid>

        <Grid item xs={12} style={{marginTop:"30px",marginBottom:"50px"}}>
        <div id="button">
            <button   type="button" className='button' onClick={TextFile}>
                <div className='button-text'>DOWNLOAD CODE FILE</div>
                <div className='button-icon'><DownloadIcon/></div>
            </button>
        </div></Grid>
        </Grid>
	
        );
}


