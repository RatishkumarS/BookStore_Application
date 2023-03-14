package com.bank.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.bankapplication.entity.Book;
import com.bank.bankapplication.repository.Bookrepository;
import com.bank.bankapplication.service.myBookListservice;

@Controller
public class MybookListController {
	
	
	@Autowired
	Bookrepository bookrepo;
	
	@Autowired
	myBookListservice booklistservice;
	
	@RequestMapping("/deletemybook/{id}")
	public String deletemybook(@PathVariable("id") int id)
	{
		booklistservice.deletebook(id);
		return "redirect:/available-books";
	}
	
	@RequestMapping("/editmybook/{id}")
	public String editmybook(@PathVariable("id") int id,Model model)
	{
		@SuppressWarnings("deprecation")
		Book b=bookrepo.getById(id);
		model.addAttribute("book",b);
		return "editmybook";	
	}

}
