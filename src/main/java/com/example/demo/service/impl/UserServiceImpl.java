package com.example.demo.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Comment;
import com.example.demo.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @PersistenceContext
  private EntityManager entityManager;

  private final UserRepository userRepository;
  private final PostRepository postRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void init() {

    User user = User.builder().name("nickname").email("test@gmail.com").build();
    userRepository.save(user);

    Comment comment1 = Comment.builder().reply("reply001").build();
    Comment comment2 = Comment.builder().reply("reply002").build();
    Comment comment3 = Comment.builder().reply("reply003").build();
    Comment comment4 = Comment.builder().reply("reply004").build();
    // Post post1 =
    // Post.builder().subject("subject1")
    // .comments(List.of(comment1, comment2)).build();
    // Post post2 =
    // Post.builder().subject("subject2")
    // .comments(List.of(comment3, comment4)).build();
    // postRepository.saveAll(List.of(post1, post2));

  }
}
