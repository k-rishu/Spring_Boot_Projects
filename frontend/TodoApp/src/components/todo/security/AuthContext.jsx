import { createContext, useState, useContext } from "react";

export const AuthContext = createContext();

export const useAuth = () =>  useContext(AuthContext)

function AuthProvider({ children }) {

    const [number, setNumber] = useState(0);
    const [isAuthenticated, setAuthenticated] = useState(false);

    function Login(username, password){
        if(username ==="Rishu" && password ==="1234")
        {
            setAuthenticated(true);
            return true;
        }
        else{
            return false;
        }
    }

    function Logout(){
        setAuthenticated(false);
    }

    const valueToBeShared = {number, isAuthenticated, Login, Logout};
    return (
        <AuthContext.Provider value={valueToBeShared}>
            {children}
        </AuthContext.Provider>
    )
}
export default AuthProvider;