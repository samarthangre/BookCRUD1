package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;

@SpringBootApplication
public class BookCrudApplication {

    private final BookService bookService;

    BookCrudApplication(BookService bookService) {
        this.bookService = bookService;
    }

	public static void main(String[] args) {
	ConfigurableApplicationContext context =	SpringApplication.run(BookCrudApplication.class, args);
	
	BookService bs = context.getBean(BookServiceImpl.class);
	
	String name,aname;
	float price;
	int id;
	 Scanner sc = new Scanner(System.in);
	 
	 while (true) {
		System.out.println("""
				1. Insert
				2. Display
				3. Update
				4. Delete
				5. Search By Author Name
				6. Exit+
				Enter Your Choice :
				""");
		int ch = sc.nextInt();
		switch (ch) {
		case 1 ->{
			System.out.println("Enter a Book Details : ");
			System.out.println("Enter a Book Name :");
			name = sc.next();
			System.out.println("Enter a Book Author Name :");
			aname = sc.next();
			System.out.println("Enter the Book Price");
			price = sc.nextFloat();
			
			bs.add(new Book(name, aname, price));
		}
		case 2->{
			bs.display().forEach(System.out::println);
		}
		case 3->{
			 System.out.println("Enter the Book ID to Update:");
			    id = sc.nextInt();
			    sc.nextLine();
			    System.out.println("Enter the New Book Name:");
			    name = sc.nextLine();

			    System.out.println("Enter the New Author Name:");
			    aname = sc.nextLine();

			    System.out.println("Enter the New Price:");
			    price = sc.nextFloat();

			    Book updatedBook = new Book(name, aname, price);
			    bs.update(updatedBook, id);
			    System.out.println("Book updated successfully!");
			
		}
		case 4->{
			System.out.println("Enter a Book Id : ");
			id = sc.nextInt();
			bs.delete(id);
		}
		case 5 ->{
			System.out.println("Enter a Author Name : ");
			aname = sc.next();
			
			bs.search(aname).forEach(System.out::println);
		}
		case  6 ->{
			System.exit(0);
		}
		default ->
		System.out.println("Invalid Choice !! ");
		}
	}

	}

}
