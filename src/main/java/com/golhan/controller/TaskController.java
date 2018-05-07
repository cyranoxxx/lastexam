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
import com.golhan.entity.Task;
import com.golhan.repository.TaskRepo;



@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepo taskRepo;

	@PostMapping
	public Task save(@RequestBody Task task) {
		return taskRepo.save(task);
	}

	@PutMapping("/{id}")
	public Task update(@PathVariable long id, @RequestBody Task task) {
		Task dbInstance = taskRepo.findById(id).get();
		dbInstance.setTaskname(task.getTaskname());
		dbInstance.setExpiredate(task.getExpiredate());
		dbInstance.setBeginingdate(task.getBeginingdate());
		return taskRepo.save(dbInstance);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		taskRepo.deleteById(id);
	}

	@GetMapping
	public List<Task> findAll() {
		return taskRepo.findAll();
	}

	@GetMapping("/{id}")
	public Task findById(@PathVariable long id) {
		return taskRepo.findById(id).get();
	}
}
