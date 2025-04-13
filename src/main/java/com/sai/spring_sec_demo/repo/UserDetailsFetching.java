package com.sai.spring_sec_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.spring_sec_demo.model.User;

public interface UserDetailsFetching extends JpaRepository<User, Integer> {

}