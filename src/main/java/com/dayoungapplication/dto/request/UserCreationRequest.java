package com.dayoungapplication.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.dayoungapplication.entity.Gender;
import com.dayoungapplication.entity.Status;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {
    @Size(min = 5, message = "USERNAME_INVALID")
    String username;
    @Size(min = 5, max = 20, message = "PASSWORD_INVALID")
    String password;
    String fullname;
    String email;
    String phoneNumber;
    String address;
    Gender gender;
    Status status;
    LocalDate dob;
}
