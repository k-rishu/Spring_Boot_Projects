import { useParams, Link } from "react-router-dom";

function WelcomeComponent(){
    const {username} = useParams();
    return (
        <>
        <h1>Welcome to Todo Page {username}</h1>
        <div className="welcome">Welcome to Todo Page!</div>
        Manage Your todos <Link to='/todos'>Click here</Link>
        </>
    )
}

export default WelcomeComponent;