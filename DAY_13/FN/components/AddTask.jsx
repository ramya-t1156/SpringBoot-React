import { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const AddTask = () => {
  const { empId } = useParams();
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const [taskName, setTaskName] = useState("");
  const [description, setDescription] = useState("");
  const [status, setStatus] = useState("Assigned");

  const handleSubmit = (e) => {
    e.preventDefault();

    const newTask = {
      taskName,
      description,
      status,
      empId: parseInt(empId),
    };

    axios
      .post("http://localhost:3001/task", newTask, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then(() => {
        alert("Task added successfully!");
        navigate(`/tasks/${empId}`);
      })
      .catch((err) => {
        console.log("Error adding task: ", err);
        alert("Failed to add task");
      });
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4 text-center">Add Task for Employee with ID {empId}</h2>

      <button onClick={() => navigate(`/tasks/${empId}`)} className="btn btn-secondary mb-3">
        ⬅ Back
      </button>

      <div className="card p-4 shadow-sm">
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label className="form-label">Task Name</label>
            <input
              type="text"
              className="form-control"
              value={taskName}
              onChange={(e) => setTaskName(e.target.value)}
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Description</label>
            <textarea
              className="form-control"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              rows="4"
              required
            ></textarea>
          </div>

          <div className="mb-3">
            <label className="form-label">Status</label>
            <select className="form-select" value={status} onChange={(e) => setStatus(e.target.value)}>
              <option value="Assigned">Assigned</option>
              <option value="Yet to start">Yet to start</option>
              <option value="In progress">In progress</option>
              <option value="Completed">Completed</option>
            </select>
          </div>

          <button type="submit" className="btn btn-primary">
            Add Task
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddTask;
