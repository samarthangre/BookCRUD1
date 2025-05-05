package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
    @Autowired
    private BookRepository br;

	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
	br.save(b);
		
	}

	@Override
	public List<Book> display() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		br.deleteById(id);
	}

	@Override
	public void update(Book b, Integer id) {
		// TODO Auto-generated method stub
		b.setId(id);
		br.save(b);
		
	}

	@Override
	public List<Book> search(String authorName) {
		// TODO Auto-generated method stub
	var bookArray = new ArrayList<Book>();
	for (Book book : br.findAll()) {
		if (book.getAuthorName().equalsIgnoreCase(authorName)) 
			bookArray.add(book);
		
	}
	return bookArray;
	}

}
