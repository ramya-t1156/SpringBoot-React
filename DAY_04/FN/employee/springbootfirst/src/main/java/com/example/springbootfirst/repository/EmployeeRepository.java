package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The angle brackets <> contain generic type parameters.
// <Employee,Integer> -> type of <Table , Primary key>
//| `Employee` | This is the **Entity class** (table model) you want to perform operations on.    |
//| `Integer`  | This is the **type of the primary key** (the ID field) of the `Employee` entity. |

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findReferenceById(int id);
}
