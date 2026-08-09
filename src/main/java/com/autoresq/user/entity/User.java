package com.autoresq.user.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int  id;
       private String firstName;
   private String lastName;
        private String    email;
   private long phone;
        private String    password;
   private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
