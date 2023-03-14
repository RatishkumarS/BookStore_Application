package com.bank.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bank.bankapplication.entity.Book;
import com.bank.bankapplication.entity.MyBookList;
import com.bank.bankapplication.service.Bookservice;
import com.bank.bankapplication.service.myBookListservice;


@Controller
public class bankController {
	@Autowired
	private Bookservice service;
	
	@Autowired
	private myBookListservice mybooklist;

	
	@GetMapping("/")
	public String getHome()
	{
		return "home";
	}

	@GetMapping("/available-books")
	public ModelAndView getBooks()
	{
		List<Book> list=service.getBooks();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("availableBooks");
//		m.addObject("Book",list);
		return new ModelAndView("availableBooks","Book",list);
	}
	
	@GetMapping("/book-register")
	public String getbookRegister()
	{
		return "bookRegister";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		return "redirect:/available-books";
	}
	
	@GetMapping("/my_book")
	public String getMybooks(Model model)
	{
		List<MyBookList> mbll=mybooklist.getAllmybooks();
		model.addAttribute("book", mbll);
		return "myBook";
	}
	
	@RequestMapping("/mybooklist/{id}")
	public String mybookList(@PathVariable("id") int id)
	{
		Book lmbl=mybooklist.getmyBookList(id);
		MyBookList mbl=new MyBookList(lmbl.getId(),lmbl.getName(),lmbl.getAuthor(),lmbl.getPrice());
		mybooklist.savebook(mbl);
		return "redirect:/my_book";		
	}
	@RequestMapping("/deletemybooks/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		service.deleteBook(id);
		return "redirect:/available-books";		
	}
}
