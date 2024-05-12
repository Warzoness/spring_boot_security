package com.dayoungapplication.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
    String password;
    String fullname;
    String email;
    String phoneNumber;
    String address;
    Gender gender;
    Status status;
    LocalDate dob;
    @ElementCollection
    Set<String> roles;
}
