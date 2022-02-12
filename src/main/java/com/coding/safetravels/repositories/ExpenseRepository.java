package com.coding.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.safetravels.models.Expense;
@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long> {
	List<Expense> findAll();
	

}
