package com.golhan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.golhan.entity.Employee;

@Entity
@Table(name="task")
public class Task extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String taskname;
	private Date expiredate;
	private Date beginingdate;
	private List<Employee> employees = new ArrayList<>();
	@Column(name = "task_name", length = 50, nullable = false)
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "expiredate", nullable = false)
	public Date getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "beginingdate", nullable = false)
	public Date getBeginingdate() {
		return beginingdate;
	}
	public void setBeginingdate(Date beginingdate) {
		this.beginingdate = beginingdate;
	}
	@ManyToMany(mappedBy = "tasks")
	@JsonIgnore
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
