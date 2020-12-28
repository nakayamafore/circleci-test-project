package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.User;
import com.example.demo.model.UserFindResponse;
import com.example.demo.service.ClassroomsService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.USER)
@RequiredArgsConstructor
public class UserController {

  private final ModelMapper mapper;
  private final ClassroomsService classroomsService;
  private final UserService userService;


  @PostMapping(Endpoint.INIT)
  public void init() {
    classroomsService.init();
  }

  @GetMapping
  public List<UserFindResponse> find() {
    List<User> result = userService.findAll();
    return result.stream().map(e -> mapper.map(e, UserFindResponse.class))
        .collect(Collectors.toList());
  }
}
