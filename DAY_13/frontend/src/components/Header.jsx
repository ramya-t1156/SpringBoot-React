import { Link , useNavigate} from "react-router-dom";

const Header = () => {
 
    const navigate = useNavigate();

    const handleLogout = ()=>{
        localStorage.clear();
        navigate("/");
    }

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
        <Link className="navbar-brand" to="/">EMS</Link>
        <div className="collapse navbar-collapse">
            <ul className="navbar-nav ms-auto">
            <li className="nav-item">
                <Link className="nav-link" to="/employee">Employees</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/search">Search</Link>
            </li>
            </ul>
            <button className="btn btn-outline-light bg-dark text-white" onClick={handleLogout}>
            Logout
            </button>
        </div>
        </nav>
    );
};

export default Header;
