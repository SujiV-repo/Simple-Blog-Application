package com.springboot.blogapplication.service;

import java.util.List;

import com.springboot.blogapplication.payload.CategoryDto;

public interface CategoryService {
	CategoryDto addCategory(CategoryDto categoryDto);
	
	CategoryDto getCategory(long categoryId); 
	
	List<CategoryDto> getAllCategories();
	
	CategoryDto updateCategory(CategoryDto categoryDto, long categoryId);
	
	void deleteCategory(long categoryId);
}
