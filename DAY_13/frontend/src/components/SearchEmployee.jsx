import React, { useState } from 'react';
import axios from 'axios';

const SearchEmployee = () => {
  const [userName, setUserName] = useState('');
  const [employees, setEmployees] = useState([]);
  const [error, setError] = useState('');

  //  RAMYA T - 23AD111
  
  const handleSearch = async (e) => {
    e.preventDefault();
    setError('');
    try {
      const token = localStorage.getItem('token'); 
      const response = await axios.get(`http://localhost:3001/employee/search`, {
        params: { userName },
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
      setEmployees(response.data);
    } catch (err) {
      setEmployees([]);
      if (err.response?.status === 404) {
        setError('No employee found with that username.');
      } else {
        setError('Something went wrong.');
      }
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Search Employee by Username</h2>
      <form className="d-flex mb-4" onSubmit={handleSearch}>
        <input
          type="text"
          className="form-control me-2"
          placeholder="Enter username..."
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
        <button className="btn btn-primary" type="submit">Search</button>
      </form>

      {error && <div className="alert alert-danger">{error}</div>}

      {employees.length > 0 && (
        <div className="table-responsive">
          <table className="table table-bordered">
            <thead className="table-light">
              <tr>
                <th>Emp ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Roles</th>
              </tr>
            </thead>
            <tbody>
              {employees.map((emp) => (
                <tr key={emp.empId}>
                  <td>{emp.empId}</td>
                  <td>{emp.userName}</td>
                  <td>{emp.email}</td>
                  <td>
                    {emp.roles.map((role) => role.roleName).join(', ')}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default SearchEmployee;
