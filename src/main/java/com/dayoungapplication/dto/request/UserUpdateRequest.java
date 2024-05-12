package com.dayoungapplication.dto.request;

import java.time.LocalDate;

import com.dayoungapplication.entity.Gender;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String email;
    String fullname;
    String phoneNumber;
    String address;
    Gender gender;
    LocalDate dob;
}
