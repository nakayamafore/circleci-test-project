package com.example.demo.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  @PersistenceContext
  private EntityManager entityManager;

  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  @Override
  public List<Comment> findAll() {
    return commentRepository.findAll();
  }

  @Override
  public void init() {

    User user = User.builder().name("nickname").email("test@gmail.com").build();
    userRepository.save(user);

    Post post1 = Post.builder()
        .subject("subject1")
        .user(user)
        .build();
    postRepository.save(post1);
    Post post2 = Post.builder()
        .subject("subject2")
        .user(user)
        .build();
    postRepository.save(post2);

    Comment comment1 = Comment.builder().reply("reply001")
        .user(user).post(post1).build();
    Comment comment2 = Comment.builder().reply("reply002")
        .user(user).post(post1).build();
    Comment comment3 = Comment.builder().reply("reply003")
        .user(user).post(post2).build();
    Comment comment4 = Comment.builder().reply("reply004")
        .user(user).post(post2).build();
    commentRepository.saveAll(List.of(comment1, comment2, comment3, comment4));

  }
}
