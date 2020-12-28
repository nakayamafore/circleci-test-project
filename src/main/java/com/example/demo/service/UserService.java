package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface UserService {
  void init();

  List<User> findAll();
}
