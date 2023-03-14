package com.bank.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.bankapplication.entity.Book;
import com.bank.bankapplication.entity.MyBookList;

public interface MyBookListRepository extends JpaRepository<MyBookList,Integer>{

}
