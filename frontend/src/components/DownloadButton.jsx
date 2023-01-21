import React from 'react';
import DownloadIcon from '@mui/icons-material/Download';

const DownloadButton = (props) => {
    return (
        <div>
            <button  id={props.id} type="button" className='button' onClick={() => props.onclick}>
                <div className='button-text'>DOWNLOAD CODE FILE</div>
                <div className='button-icon'><DownloadIcon/></div>
            </button>
        </div>
    );
};

export default DownloadButton;