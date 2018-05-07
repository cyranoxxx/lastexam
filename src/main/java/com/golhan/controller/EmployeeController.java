package com.golhan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.golhan.entity.Employee;
import com.golhan.entity.Task;
import com.golhan.repository.EmployeeRepo;
import com.golhan.repository.TaskRepo;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	private TaskRepo taskRepo;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {	
		return employeeRepo.save(employee); 
	}
	public Task save(@RequestBody Task task) {
		return taskRepo.save(task);
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable long id, @RequestBody Employee employee) {
		Employee dbInstance = employeeRepo.findById(id).get();
		dbInstance.setFirstname(employee.getFirstname());
		dbInstance.setLastname(employee.getLastname());
		dbInstance.setTasks(employee.getTasks());
		return employeeRepo.save(dbInstance);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		employeeRepo.deleteById(id);
	}

	@GetMapping
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable long id) {
		return employeeRepo.findById(id).get();
	}

}
