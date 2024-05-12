package com.dayoungapplication.dto.response;

import com.dayoungapplication.entity.Gender;
import com.dayoungapplication.entity.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
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
}
