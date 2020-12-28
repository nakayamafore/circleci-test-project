package com.example.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import lombok.Data;

@Data
@MappedSuperclass
public class Audit {
  private String createdBy;
  private LocalDateTime createdAt;
  private String updateBy;
  private LocalDateTime updatedAt;
  @Version
  private Long version;

  @PrePersist
  public void prePersist() {
    LocalDateTime now = LocalDateTime.now();
    this.createdAt = now;
    this.updatedAt = now;
  }

  @PreUpdate
  public void preUpdate() {
    LocalDateTime now = LocalDateTime.now();
    this.updatedAt = now;
  }
}
