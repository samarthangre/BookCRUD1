package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;



public interface BookService {
	 public void add(Book b);
	 public List <Book> display();
	 public void delete(Integer id); 
	 public void update (Book b , Integer id);
	 public List<Book> search(String authorName);
		
	

}
