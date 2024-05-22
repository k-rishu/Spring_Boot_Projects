import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";


function LoginComponent(){
    const [username, setUsername] = useState("Rishu");
    const [password, setPassword] = useState("Password");
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);
    const [showFailureMessage, setShowFailureMessage] = useState(false);
    const navigate =  useNavigate()
    const authContext = useAuth()

    function handleUserNameChange(event){
        setUsername(event.target.value);
    }
    function handlePasswordChange(event){
        setPassword(event.target.value);
    }
    function handleClick(event){
        if(authContext.Login(username, password)){
            navigate(`/welcome/${username}`);
        }
        else {
            // console.log("error");
            setShowFailureMessage(true);
        }
    }
    return (
        <>
        {showFailureMessage && <div className="success">"Authentication Failed, Please verify the credentials and try again"</div>}

        <div className="Username">
            <label >UserName</label>
            <input type="text" name="userName" value={username} onChange={handleUserNameChange}/>
        </div>
        <div className="pasword">
            <label >Password</label>
            <input type="password" name="password" onChange={handlePasswordChange}/>
        </div>
        <div className='LoginButton'>
            <button onClick={handleClick}>Login</button>
        </div>
        </>
    )    
}

export default LoginComponent;