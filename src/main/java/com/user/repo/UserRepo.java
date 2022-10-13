package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}
