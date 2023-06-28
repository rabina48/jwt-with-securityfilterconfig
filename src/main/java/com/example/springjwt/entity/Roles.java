package com.example.springjwt.entity;

import com.fasterxml.jackson.databind.deser.Deserializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.serializer.Deserializer;

import java.util.List;

/**
 * @author : Rabina Shrestha
 * @Date : 28/06/2023
 * @email : rabina.shrestha@codehimalaya.tech
 */
@Getter
@Setter
@Entity
@Table(name = "roles_table")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name") 
    private String roleName;




}

