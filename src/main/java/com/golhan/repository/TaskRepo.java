package com.golhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.golhan.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{

}
