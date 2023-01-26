import React from 'react';
import CodeEditor, { SelectionText } from "@uiw/react-textarea-code-editor";
import './style.css'
import { useEffect, useState } from 'react';

const CodeTextEditor = (generatedCode) => {

    const [code, setCode] = React.useState( {data : ""},
        generatedCode
      );
      
    return (
        <div >
        <CodeEditor
          value={code}
          language="java"
          placeholder="// Test Generator V1.0"
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
    );
};

export default CodeTextEditor;