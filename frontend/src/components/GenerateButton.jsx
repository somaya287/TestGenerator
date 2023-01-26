import React from 'react';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

const GenerateButton = (generateCode) => {

    return (
        <div>
            <button type="button" className='button' onClick={generateCode}>
                <div className='button-text'>GENERATE TESTS</div>
                <div className='button-icon'><ArrowForwardIcon/></div>
            </button>
        </div>
    );
};

export default GenerateButton;