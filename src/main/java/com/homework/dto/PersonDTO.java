package com.homework.dto;


import com.homework.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
}
