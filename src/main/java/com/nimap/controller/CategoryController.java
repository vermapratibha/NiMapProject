package com.nimap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.model.Category;
import com.nimap.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@GetMapping("/api/categories")
	public ResponseEntity getCategory() {
		List<Category>  list = cservice.GetCategories();
		ResponseEntity  response= new ResponseEntity( list,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/api/categories")
	public ResponseEntity createNewCategory(@RequestBody Category cat) {
		Category addcategory = cservice.AddCategory(cat);
		ResponseEntity<Category>  response= new ResponseEntity<Category>(addcategory,HttpStatus.OK);
		return response;		
	}
	
	@GetMapping("/api/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category getcategory= cservice.GetCategoryById(id);
		ResponseEntity<Category>  response= new ResponseEntity<Category>(getcategory,HttpStatus.OK);
		return response;
	}
	@PutMapping("api/categories/{id}")
	public ResponseEntity<Category> updateCategoryById(@PathVariable int id, @RequestBody String name) {
		Category updateCategory= cservice.GetCategoryById(id);
		
		updateCategory.setName(name);
		Category newCategory=cservice.AddCategory(updateCategory);
		ResponseEntity<Category>  response= new ResponseEntity<Category>(newCategory,HttpStatus.OK);
		return response;

	}
	@DeleteMapping("api/categories/{id}")
	public void deleteCategoryById(@PathVariable int id) {
		cservice.DeleteCategory(id);
	}



}
