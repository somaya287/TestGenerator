import React from 'react'
import './style.css';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import AddDiagrammesService from "../services/AddDiagrammeService"

import Button from '@mui/material/Button';

export default function  Title () {
      const [diagramme, setDiagramme] = React.useState('');

      const handleChange = e => {
        setDiagramme(e.target.value);
        
    };
    const styles = theme => ({
        notchedOutline: {
          borderWidth: "1px",
          borderColor: "yellow !important"
        }
      });
      
      const handleSubmit = (event) => {

        AddDiagrammesService (event,diagramme)
    };
    return( <div>
            <img  className="imgz" src="./Logo.png" />

    <p className="text">PASSWORD GENERATOR</p> 

    <Box sx={{ minWidth: 120 }} onSubmit={handleSubmit}>
    <label className='txtField1' style={{color:"white"}}for="standard-select">Select Diagram type</label>

   <select  onChange={handleChange} 
 className='txtField' name="Diagramme" id="Diagramme"  >
            <option value="Diagramme de Séquence" style={{color:"white"}} selected>Diagramme de Séquence</option>
            <option value="Diagramme de Séquence">Diagramme d'activité</option>
           

    </select>
    <label  className='txtField2' style={{color:"white"}}for="standard-select">Upload your diagrame(.io)</label>

        <input id="file" className='txtinpt' type="file" name="country"  placeholder="Select Diagram type"  ></input>
      
    </Box>
    </div>
    );
}

