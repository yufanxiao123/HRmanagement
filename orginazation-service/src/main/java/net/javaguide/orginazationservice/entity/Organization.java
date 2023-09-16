package net.javaguide.orginazationservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "organizations")
@Data
public class Organization {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String organizationName;
   private String organizationDescription;
   @Column(nullable = false, unique = true)
   private String organizationCode;
   @CreationTimestamp
   private LocalDateTime createdDate;
}
