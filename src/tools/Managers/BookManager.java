/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Managers;

import entity.Book;
import java.util.Scanner;

/**
 *
* @author Sander Rubenkov
 */
public class BookManager {
        public Book createBook() {
            Scanner input = new Scanner(System.in);
            Book book = new Book();
            System.out.print("Введите название кники: ");
            book.setName(input.nextLine());
            System.out.print("Введите Автора: ");
            book.setAuthor(input.nextLine());
            System.out.print("Введите год издание книги: ");
            book.setPublishedYear(input.nextInt());
            System.out.println("Добавлена книга: " + book.getName());
            return book;

    }

    public void addBook(Book book, Book[] books) {
        for(int i = 0; i < books.length; i++) {
            if (books[i] ==  null){
                books[i] = book;
                System.out.printf("Добавлена книга: %s%n", books[i].getName());
                break;
            }
        }
        if (books[99] != null){
            System.out.println("В библиотеке закончилось место.");
        }
    }

    public void printBooksList(Book[] books) {
        for (int i = 0; i < books.length; i++){
                        if(books[i] != null){
                            System.out.printf("%3d. Название книги: %s%n     Автор: %s%n"
                                    ,i+1
                                    ,books[i].getName()
                                    ,books[i].getAuthor());
                        }
                    }
    }
}
