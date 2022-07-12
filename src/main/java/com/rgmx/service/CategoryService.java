package com.rgmx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgmx.Repository.CategoryRepository;
import com.rgmx.entity.Category;
import com.rgmx.model.CategoryModel;


@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;
	
	public void save(CategoryModel categorymodel) {
		Category category=new Category(categorymodel.getName());
		repository.save(category);
	}
	
	public List<Category> category_list() {
		return repository.findAll();
	}
	public Category findById(Long id) {
		return repository.findById(id);
	}
	public void updateCategory(Category category) {
		Category category1=findById(category.getId());
		category1.setName(category.getName());
		repository.save(category1);
	}
}
