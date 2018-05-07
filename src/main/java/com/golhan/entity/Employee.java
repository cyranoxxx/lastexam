package com.golhan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.golhan.entity.Task;


@Entity
@Table(name="employee")
public class Employee extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private List<Task> tasks = new ArrayList<>();
	
	@Column(name = "first_name", length = 50, nullable = false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "last_name", length = 50, nullable = false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_task",
    joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id"))
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
