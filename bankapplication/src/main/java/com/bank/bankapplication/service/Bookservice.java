package com.bank.bankapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankapplication.entity.Book;
import com.bank.bankapplication.entity.MyBookList;
import com.bank.bankapplication.repository.Bookrepository;
import com.bank.bankapplication.repository.MyBookListRepository;

@Service
public class Bookservice {
	
	@Autowired
	private Bookrepository bookrepo;
	
	@Autowired
	private MyBookListRepository booklistrepo;
	
	public void save(Book b)
	{
		bookrepo.save(b);
	}
	
	public List<Book> getBooks(){
		return bookrepo.findAll();
	}
	
	public void deleteBook(int id)
	{
		bookrepo.deleteById(id);
	}
	
	
}
