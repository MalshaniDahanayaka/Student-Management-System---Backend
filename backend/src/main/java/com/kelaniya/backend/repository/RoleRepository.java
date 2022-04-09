package com.example.springbootauthwithjwt.repository;

import com.example.springbootauthwithjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {
}
