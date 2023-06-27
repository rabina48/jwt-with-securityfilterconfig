package com.example.springjwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Rabina Shrestha
 * @Date : 26/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Entity
@Getter
@Setter
@Table( name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String department;

}
