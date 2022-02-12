package com.coding.safetravels.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.safetravels.models.Expense;
import com.coding.safetravels.services.ExpenseService;

@Controller
public class ExpenseController{
	
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String home() {
		return "Hello";
	}
	
//	HOME
	 @GetMapping("/expense") 
	 public String expense(Model model, @ModelAttribute("expense") Expense expense){
	 
		 List<Expense> expenses=expenseService.allExpenses();
		 model.addAttribute("expenses", expenses);
		return "Home.jsp" ;
	 }
	 
//	 CREATE
	 @PostMapping("/expense") 
	 public String newExpense(
			 @ Valid @ModelAttribute("expense") Expense expense,
			 BindingResult result, Model model)  {
		 
		 if (result.hasErrors()) {
			 List<Expense> expenses=expenseService.allExpenses();
			 model.addAttribute("expenses", expenses);
			 return "Home.jsp";
		 }
		 expenseService.createExpense(expense);
	 
		return "redirect:/expense" ;
	 }
	 
//	 DELETE
	 @DeleteMapping("/expense/{id}")
	 public String delete(@PathVariable("id")Long id) {
		 expenseService.deleteExpense(id);
		 return "redirect:/expense";
	 }
//	 READ ONE AND RENDER TO EDIT PAGE
	 @GetMapping("/expense/{id}") 
	 public String oneExpense(Model model,@PathVariable("id") Long id){
		 
		 
		 Expense expense=expenseService.findExpense(id);
		 if (expense !=null) {
			 
			 model.addAttribute("expense", expense);
			 return "OneExpense.jsp" ;
		 }
		 else {
			 return "redirect:/expense";
		 }
	 }
	 
//	 READ ONE AND SHOW PAGE
	 @GetMapping("/expense/{id}/show") 
	 public String showExpense(Model model,@PathVariable("id") Long id){
		 
		 
		 Expense expense=expenseService.findExpense(id);
		 if (expense !=null) {
			 
			 model.addAttribute("expense", expense);
			 return "ShowExpense.jsp" ;
		 }
		 else {
			 return "redirect:/expense";
		 }
	 }
	 
	 
//	 EDIT
	 @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
		public String editExpense(@PathVariable ("id")Long id,
				@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			
		 if (result.hasErrors()) {
			 return "OneExpense.jsp";
		 } else {
			 expenseService.updateExpense(expense);
			 return "redirect:/expense";
		 }
			
			
		}
}