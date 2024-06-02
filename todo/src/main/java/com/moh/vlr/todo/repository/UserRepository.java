package com.moh.vlr.todo.repository;

import com.moh.vlr.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.userId = ?1")
    void deleteUserByUserId(Long userId);
}
