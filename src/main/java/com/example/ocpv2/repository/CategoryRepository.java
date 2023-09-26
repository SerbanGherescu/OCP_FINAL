package com.example.ocpv2.repository;

import com.example.ocpv2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    Optional<Category> findByName(String name);

    void deleteByName(String name);

}
