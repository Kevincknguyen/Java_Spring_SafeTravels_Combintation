package com.coding.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.safetravels.models.Expense;
import com.coding.safetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo=expenseRepo;
	}

	
	public List<Expense> allExpenses() {
	     return expenseRepo.findAll();
	 }
	
	
	public Expense createExpense(Expense b) {
		 return expenseRepo.save(b);
	 }
	
	public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepo.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 	}
	
	
	public String findById(Long id) {
	     Optional<Expense> optionalExpense = expenseRepo.findById(id);
	     if(optionalExpense.isPresent()) {
	         expenseRepo.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No expense with ID found";
	     }
	 	}
	
	public String deleteExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepo.findById(id);
	     if(optionalExpense.isPresent()) {
	    	 expenseRepo.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No expense with ID found";
	     }
	 	}
	
	 public Expense updateExpense(Expense expense) {
	     Optional<Expense> optionalExpense = expenseRepo.findById(expense.getId());
	     if(optionalExpense.isPresent()) {
	    	 Expense newExpense=optionalExpense.get();
	    	 newExpense.setName(expense.getName());
	    	 newExpense.setDescription(expense.getDescription());
	    	 newExpense.setVendor(expense.getVendor());
	    	 newExpense.setAmount(expense.getAmount());
	    	 
	    
	    	 
	    	
	         expenseRepo.save(newExpense);
	         return newExpense;
	         
	     } 
	     else {
	    	 return null;
	     }
	 	}
	
	
	
	
}
