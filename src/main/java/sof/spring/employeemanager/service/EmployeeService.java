package sof.spring.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sof.spring.employeemanager.exception.UserNotFoundException;
import sof.spring.employeemanager.model.Employee;
import sof.spring.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    //Return all the employees
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    //Update an employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    //Delete an employee
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    //Find an employee by id
    public Employee findEmployeeById(long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("There is no user for the id : " + id));
    }
}
