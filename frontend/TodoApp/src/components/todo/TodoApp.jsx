import './TodoApp.css';
import {BrowserRouter, Routes, Route, useNavigate, useParams, Link, Navigate} from 'react-router-dom';
import LogoutComponent from './LogoutComponent'
import LoginComponent from './LoginComponent';
import WelcomeComponent from './WelcomeCompenent';
import ListTodosComponent from './ListTodosComponent';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComonent';
import ErrorComponent from './ErrorComponent';
import AuthProvider, { useAuth } from './security/AuthContext';

function TodoApp(){

    function AuthenticatedComponent({children}){
        const authContext = useAuth();
        if(authContext.isAuthenticated)
            return children
        else{
            return <Navigate to='/'/>
        }
    }

    return (
        <>
        <div>
            <AuthProvider>
            <BrowserRouter>
            <HeaderComponent/>
                <Routes>
                    <Route path="/" element={<LoginComponent/>}></Route>
                    <Route path="/login" element={<LoginComponent/>}></Route>
                    <Route path="/welcome/:username" element={
                        <AuthenticatedComponent>
                            <WelcomeComponent/>
                        </AuthenticatedComponent>}>
                    </Route>
                    <Route path="/todos" element={
                        <AuthenticatedComponent>
                            <ListTodosComponent/>
                        </AuthenticatedComponent>}>
                    </Route>
                    <Route path="/logout" element={
                        <AuthenticatedComponent>
                            <LogoutComponent/>
                        </AuthenticatedComponent>}>
                    </Route>
                    <Route path="*" element={<ErrorComponent/>}></Route>
                </Routes>
                <FooterComponent/>
            </BrowserRouter>
            </AuthProvider>
        </div>
       
        </>
    )
}

export default TodoApp;