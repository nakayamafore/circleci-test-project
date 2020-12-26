package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(
    name = "post-entity-graph",
    attributeNodes = {
        @NamedAttributeNode("subject"),
        @NamedAttributeNode("user"),
        @NamedAttributeNode("comments"),
    })
public class Post implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String subject;

  @OneToMany(mappedBy = "post")
  // @JsonManagedReference
  // @JsonIgnore
  private List<Comment> comments;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn
  private User user;
}
