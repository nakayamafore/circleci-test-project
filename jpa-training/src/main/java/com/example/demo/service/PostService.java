package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Post;

public interface PostService {
  void init();

  List<Post> findAll();
}
