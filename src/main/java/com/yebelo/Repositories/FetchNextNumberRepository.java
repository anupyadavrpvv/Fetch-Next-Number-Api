package com.yebelo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yebelo.model.CategoryValueEntity;

public interface FetchNextNumberRepository extends JpaRepository<CategoryValueEntity, Integer> {
		
}
