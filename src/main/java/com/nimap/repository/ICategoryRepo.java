package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.model.Category;

@Repository
public interface ICategoryRepo extends JpaRepository<Category,Integer> {

}
