package com.moh.vlr.todo.repository;

import com.moh.vlr.todo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByNameIgnoreCase(String name);

    Optional<Category> findByCategoryId(Long categoryId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c.categoryId = ?1")
    void deleteByCategoryId(Long categoryId);
}
