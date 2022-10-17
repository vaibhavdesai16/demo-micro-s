package com.prongzz.sagatutorial.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document
public class Order {
  @Id private String id;

  private LocalDateTime createdOn;

  private String createdBy;
}
