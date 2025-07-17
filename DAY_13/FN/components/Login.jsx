import { useState} from "react";
import { useNavigate , Link} from "react-router-dom";
import axios from "axios";

const Login = () => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate()

  async function handleLogin(event){
    event.preventDefault();
    try{
        const response = await axios.post("http://localhost:3001/api/auth/login",{userName,password})
        console.log(response);

        const{token,username,roles} = response.data;

        localStorage.setItem("token",token);
        localStorage.setItem("username",username);

        const rolesArray = response.data.roles.split(',').map(role=>role.trim())
        localStorage.setItem("roles",JSON.stringify(rolesArray))

        alert("Login successful!");
        
        navigate("/dashboard")
    } catch (e){
        console.log("Login Error", e);
        alert("Invalid Cred")
    }
    console.log("Form Submitted");
  }
  return (
    <div className="container login-container" style={{ maxWidth: "500px" , maxHeight:"500px"}}>
      <h2 className="mb-4 text-center">Login</h2>
      <div className="card p-4 shadow">
        <form onSubmit={handleLogin}>
          
          <div className="mb-3">
            <label htmlFor="userName">User Name</label>
              <input
              id="userName"
              name="userName"
              value={userName}
              type="text"
              onChange={(e) => setUserName(e.target.value)}
              required
            />
          </div>
          
          <div className="mb-3">
            <label htmlFor="password">Password</label>
            <input
              id="password"
              name="password"
              value={password}
              type="password"
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <div className="d-grid">
            <button type="submit" className="btn btn-primary">Login</button>
          </div>

           <div className="mt-3 text-center">
            <span>Don't have an account? </span>
            <Link to="/register" className="text-decoration-none">Register</Link>
          </div>

        </form>
      </div>
    </div>
  );
};
export default Login;