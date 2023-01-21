import React from 'react'
import './style.css';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';




export default function  Title () {
      const [age, setAge] = React.useState('');

      const handleChange = e => {
        setAge(e.target.value);
        
    };
    const styles = theme => ({
        notchedOutline: {
          borderWidth: "1px",
          borderColor: "yellow !important"
        }
      });
      

    return( <div>
            <img  className="imgz" src="./Logo.png" />

    <p className="text">PASSWORD GENERATOR</p> 

    <Box sx={{ minWidth: 120 }}>
    <label className='txtField' style={{color:"white"}}for="standard-select">Select Diagram type</label>

   <select className='txtField' name="country" id="country" placeholder="Select Diagram type" label="Select Diagram type">
            <option value="Diagramme de Séquence">Diagramme de Séquence</option>
            <option value="Diagramme de Séquence">Diagramme d'activité</option>
            
        </select>

        <input className='txtinpt' type="file" name="country" id="country" placeholder="Select Diagram type"  ></input>
    </Box>
    </div>
    );
}

