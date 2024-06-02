package com.danunaik.testtry.Controller;

import com.danunaik.testtry.entity.Employee;
import com.danunaik.testtry.services.EmailService;
import com.danunaik.testtry.services.EmployeeService;
import com.danunaik.testtry.services.OTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeCoontroller {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmailService service;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
    @GetMapping("/send-otp")
    public ResponseEntity<String> sendOTP(@RequestParam String email) {
        String otp = OTPGenerator.generateOTP();
        service.sendEmail(email, otp);
        return ResponseEntity.ok("OTP sent successfully to " + email);
    }
}
