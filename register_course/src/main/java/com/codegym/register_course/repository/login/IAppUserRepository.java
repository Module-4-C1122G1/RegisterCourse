package com.codegym.register_course.repository.login;

import com.codegym.register_course.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUserName(String userName);
}
