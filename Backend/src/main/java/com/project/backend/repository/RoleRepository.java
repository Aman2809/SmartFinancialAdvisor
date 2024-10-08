package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
