package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UsersRole,String> {

    @Transactional
    @Query("FROM users_role where user_email = ?1")
    UsersRole getUserRole(String studentEmail);

}
