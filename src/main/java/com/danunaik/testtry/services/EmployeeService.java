package com.danunaik.testtry.services;

import com.danunaik.testtry.Repositories.EmployeeRepository;
import com.danunaik.testtry.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public String saveEmployee(Employee employee) {
        repository.save(employee);
        return "Successfully added Employee";
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public String updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(updatedEmployee.getName());
               existingEmployee.setEmail(updatedEmployee.getEmail());
               existingEmployee.setPassword(updatedEmployee.getPassword());
            // Set other properties as needed
            repository.save(existingEmployee);
            return "Successfully updated Employee";
        } else {
            return "Employee not found";
        }
    }

    public String deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            repository.deleteById(id);
            return "Successfully deleted Employee";
        } else {
            return "Employee not found";
        }
    }
}
