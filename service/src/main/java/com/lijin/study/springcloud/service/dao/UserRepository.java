package com.lijin.study.springcloud.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.lijin.study.springcloud.service.dao.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
