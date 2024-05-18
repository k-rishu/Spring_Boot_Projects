import "./Counter.css"
import { useState } from "react";
import CounterButton from "./CounterButton";



export default function Counter(){
    const [count, setCount] = useState(0);

    function incrementCounteParentFunction(by){
        setCount(count + by);
    }
    function decrementCounterParentFunction(by){
        setCount(count - by);
    }
    function reset(){
        setCount(0);
    }
   
    return(
        <>  
        <span className="count">{count}</span>
        <CounterButton by={1}
        increment={incrementCounteParentFunction}
        decrement={decrementCounterParentFunction}/>
        <CounterButton by={2}
         increment={incrementCounteParentFunction}
         decrement={decrementCounterParentFunction}/>
        <CounterButton by={5}
         increment={incrementCounteParentFunction}
         decrement={decrementCounterParentFunction}/>
         <button className="counterButton" onClick={reset}>Reset</button>
        </>
    )
}


