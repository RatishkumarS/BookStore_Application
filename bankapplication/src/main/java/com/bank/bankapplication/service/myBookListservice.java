package com.bank.bankapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankapplication.entity.Book;
import com.bank.bankapplication.entity.MyBookList;
import com.bank.bankapplication.repository.Bookrepository;
import com.bank.bankapplication.repository.MyBookListRepository;

@Service
public class myBookListservice {
	
	@Autowired
	MyBookListRepository booklistrepo;
	
	@Autowired
	Bookrepository bookrepo;
	
	//getting Book record 
	@SuppressWarnings("deprecation")
	public Book getmyBookList(int id)
	{
		return bookrepo.getById(id);
	}
	//saving Booklist records
	public void savebook(MyBookList mbl)
	{
		booklistrepo.save(mbl);
	}
	//getting list  of mybooklist
	public List<MyBookList> getAllmybooks()
	{
		return booklistrepo.findAll(); 
	}
	
	public void deletebook(int id)
	{
		booklistrepo.deleteById(id);
	}

}
