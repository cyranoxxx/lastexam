package com.golhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.golhan.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
