package com.bank.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bankapplication.entity.Book;

@Repository
public interface Bookrepository extends JpaRepository<Book,Integer>{
	

}
