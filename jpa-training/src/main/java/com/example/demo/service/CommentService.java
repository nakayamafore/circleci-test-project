package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Comment;

public interface CommentService {
  void init();

  List<Comment> findAll();
}
