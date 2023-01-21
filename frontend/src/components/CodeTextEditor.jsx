import React from 'react';
import CodeEditor, { SelectionText } from "@uiw/react-textarea-code-editor";
import './style.css'
import { useEffect, useState } from 'react';

const CodeTextEditor = () => {

    const [code, setCode] = React.useState( {data : ""}
        `function add(a, b) {\n  return a + b;\n}`
      );
      
    return (
        <div >
        <CodeEditor
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
    );
};

export default CodeTextEditor;