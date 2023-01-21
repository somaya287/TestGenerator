import React from 'react'
import CodeTextEditor from './CodeTextEditor';
import Title from "./Title"
import Grid from '@mui/material/Grid';
import DownloadButton from './DownloadButton';
import GenerateButton from './GenerateButton';

export default function Home ()  {
    return(
        <Grid
        container
        direction="column"
        justifyContent="space-between"
        alignItems="stretch"
      >
        <Grid item xs={12}>

        <Title/>
      
   
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


