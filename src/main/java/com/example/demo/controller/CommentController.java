package com.example.demo.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.COMMENT)
@RequiredArgsConstructor
public class CommentController {

  private final ModelMapper mapper;
  private final CommentService commentService;


  @PostMapping(Endpoint.INIT)
  public void init() {
    commentService.init();
  }

  @GetMapping
  public List<Comment> find() {
    List<Comment> result = commentService.findAll();
    // return result.stream()
    // .map(e -> mapper.map(e, CommentFindResponse.class))
    // .collect(Collectors.toList());
    return result;
  }
}
