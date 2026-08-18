package com.library.library_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.library_management.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}