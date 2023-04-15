package com.codegym.register_course.repository.login;

import com.codegym.register_course.model.AppUser;
import com.codegym.register_course.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser user);
}
