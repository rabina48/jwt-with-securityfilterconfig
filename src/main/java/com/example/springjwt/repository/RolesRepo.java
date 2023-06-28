package com.example.springjwt.repository;


import com.example.springjwt.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {
    @Query(value = """ 
            select * from roles_table where role_id = ?1""",
            nativeQuery = true)
    List<Roles> findRole(List<Integer> roleId);


}
