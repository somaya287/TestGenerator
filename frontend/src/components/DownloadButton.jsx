import React from 'react';
import DownloadIcon from '@mui/icons-material/Download';

const DownloadButton = () => {
    return (
        <div>
            <button type="button" className='button' onClick={() => console.log('click')}>
                <div className='button-text'>DOWNLOAD CODE FILE</div>
                <div className='button-icon'><DownloadIcon/></div>
            </button>
        </div>
    );
};

export default DownloadButton;