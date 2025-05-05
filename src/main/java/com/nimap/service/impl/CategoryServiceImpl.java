package com.nimap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.Category;
import com.nimap.repository.ICategoryRepo;
import com.nimap.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
ICategoryRepo repo;
	@Override
	public List<Category> GetCategories() {
		return repo.findAll();
	}

	@Override
	public Category GetCategoryById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Category AddCategory(Category cat) {
		 return repo.save(cat);
	}

	@Override
	public Category UpdateCategory(Category cat) {
		return repo.save(cat);
	}

	@Override
	public void DeleteCategory(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}

}
