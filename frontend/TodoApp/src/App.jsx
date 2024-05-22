import { useState } from 'react'
import TodoApp from './components/todo/TodoApp'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <TodoApp/>
    </>
  )
}

export default App
