package com.vikas.user.userManagement.repositories;

import com.vikas.user.userManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
