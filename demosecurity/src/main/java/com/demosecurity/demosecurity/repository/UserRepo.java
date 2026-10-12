package com.demosecurity.demosecurity.repository;
import com.demosecurity.demosecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
