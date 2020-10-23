package com.midlife.exams.jpa.repo.security;

import com.midlife.exams.jpa.entities.security.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepo extends JpaRepository<UserRolesEntity,Long> {
    UserRolesEntity findByRole(String role);
}
