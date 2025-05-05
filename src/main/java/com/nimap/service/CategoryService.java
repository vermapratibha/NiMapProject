package com.nimap.service;

import java.util.List;

import com.nimap.model.Category;

public interface CategoryService  {
	 List<Category> GetCategories();

	 Category GetCategoryById(int id);

	 Category AddCategory(Category cat);

	 Category UpdateCategory(Category cat);

	 void DeleteCategory(int id);


}
