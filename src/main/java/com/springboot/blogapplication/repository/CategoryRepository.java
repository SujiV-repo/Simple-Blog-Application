package com.springboot.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blogapplication.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
