package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.Post;
import com.example.demo.model.PostFindResponse;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.POST)
@RequiredArgsConstructor
public class PostController {

  private final ModelMapper mapper;
  private final PostService postService;


  @PostMapping(Endpoint.INIT)
  public void init() {
    postService.init();
  }

  @GetMapping
  public List<PostFindResponse> find() {
    List<Post> result = postService.findAll();
    return result.stream()
        .map(e -> mapper.map(e, PostFindResponse.class))
        .collect(Collectors.toList());
  }
}
