package com.homework.model;

import com.homework.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@SequenceGenerator(name = "persons_sequence", sequenceName = "persons_sequence", allocationSize = 1)
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_sequence")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
