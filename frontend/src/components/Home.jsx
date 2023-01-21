import React from 'react'
import CodeTextEditor from './CodeTextEditor';
import Title from "./Title"
import Grid from '@mui/material/Grid';
import DownloadButton from './DownloadButton';
import GenerateButton from './GenerateButton';
import  {useEffect, useState} from "react";
import Box from '@mui/material/Box';
import './style.css';

import AddDiagrammesService from "../services/AddDiagrammeService"
export default function Home ()  {
    const [diagramme, setDiagramme] = React.useState('');
    const [result, setResult] = React.useState('');
    /* 
        AddDiagrammesService (event,diagramme,setResult)*/
   
        
    const handleSubmit = (event) => {
 
   AddDiagrammesService (event,diagramme,setResult)
      
  };

   const handleChange = e => {
    setDiagramme(e.target.value);
   
  };

  const styles = theme => ({
    notchedOutline: {
      borderWidth: "1px",
      borderColor: "yellow !important"
    }
  });
  
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
    <label  className='txtField2' style={{color:"white"}}for="standard-select">Upload your Diagram(.)</label>

        <input id="file" className='txtinpt' type="file" name="country"  placeholder="Select Diagram type"  ></input>
      
    </Box>
   
    </div>
    </Grid>

    <Grid item xs={12} style={{marginTop:"600px"}}>
    <GenerateButton />

    </Grid>
    <Grid item xs={12}
  container
  direction="row"
  justifyContent="center"
  alignItems="stretch"
>

    <Grid xs={1}></Grid>
    <Grid item xs={8} style={{marginTop:"30px"}}>
    <CodeTextEditor/>

    </Grid>
    <Grid xs={1}></Grid>
        </Grid>

        <Grid item xs={12} style={{marginTop:"30px",marginBottom:"50px"}}>
    <DownloadButton />

    </Grid>
        </Grid>
	
        );
}


