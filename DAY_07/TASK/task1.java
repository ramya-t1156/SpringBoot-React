// TASK 1 - Update query by id

public String updateEmployeeById(int id, RegisterDetails updatedData) {
        RegisterDetails existing = regRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existing.setName(updatedData.getName());
        existing.setUserName(updatedData.getUserName());
        existing.setEmail(updatedData.getEmail());
        regRepo.save(existing);
        return "Employee updated successfully";
}
