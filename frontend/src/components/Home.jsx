import React from 'react'
import CodeTextEditor from './CodeTextEditor';
import Title from "./Title"
import {Stack} from "@mui/material"
import DownloadButton from './DownloadButton';

export default function Home ()  {
    return(
	<div>
        <Title/>
        <DownloadButton/>
        <CodeTextEditor/>
    </div>
        );
}


