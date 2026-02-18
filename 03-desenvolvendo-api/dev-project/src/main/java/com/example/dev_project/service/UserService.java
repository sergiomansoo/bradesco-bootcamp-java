package com.example.dev_project.service;

import com.example.dev_project.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}