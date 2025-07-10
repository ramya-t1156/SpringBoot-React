// TASK 1 - Update query by id


// Controller
@PutMapping("/{id}")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails reg){
        return employeeService.updateEmployeeById(id, reg);
}


// Service
public String updateEmployeeById(int id, RegisterDetails updatedData) {
        RegisterDetails existing = regRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existing.setName(updatedData.getName());
        existing.setUserName(updatedData.getUserName());
        existing.setEmail(updatedData.getEmail());
        existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        existing.setRoles(updatedData.getRoles());

        regRepo.save(existing);
        return "Employee updated successfully";
}
