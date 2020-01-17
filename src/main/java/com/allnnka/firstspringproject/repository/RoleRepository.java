package com.allnnka.firstspringproject.repository;
import com.allnnka.firstspringproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String role);
}