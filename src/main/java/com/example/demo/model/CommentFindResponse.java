package com.example.demo.model;

import java.io.Serializable;
import com.example.demo.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentFindResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Comment comment;
}
