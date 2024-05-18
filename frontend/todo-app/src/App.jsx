import { Component, useState } from 'react'
import Counter from './components/counter/Counter'

import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className="App">
        <Counter by={2}/>
      </div>

    </>
  )
}




export default App
