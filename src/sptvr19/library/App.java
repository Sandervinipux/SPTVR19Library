/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19.library;


import tools.Managers.HistoryManager;
import tools.BookRead;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookFactory;
import tools.Savers.BookSaver;
import tools.Savers.HistorySaver;
import tools.ReadFactory;
import tools.Savers.ReadSaver;
import tools.Managers.BookManager;
import tools.Managers.ReaderManager;

/**
 *
* @author Sander Rubenkov
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[200];
    BookManager man = new BookManager();
    ReaderManager readerManager = new ReaderManager(); 
    public App() {
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile(books);
        ReadSaver readSaver = new ReadSaver();
        readers = readSaver.loadFile(readers);
        HistorySaver historySaver = new HistorySaver();
        histories = historySaver.loadFile(histories);
    }
    
    public void run() {
        int amountBook = 0;
        int amountReaders = -1;
        boolean repeat = true;
        System.out.println("<--- Библиотека --->");
        do {
            System.out.println("Список задач:");
            System.out.println("(0) - Выйти из библиотеки");
            System.out.println("(1) - Добавить новую книгу");
            System.out.println("(2) - Посмотреть список книг");
            System.out.println("(3) - Зарегестрировать пользователя");
            System.out.println("(4) - Вывести списко читателей");
            System.out.println("(5) - Выдать книгу читателю");
            System.out.println("(6) - Вернуть книгу в библиотеку");
            System.out.println("(7) - Список читаемых книг");
            System.out.println("Выберите задачу:");
            Scanner input = new Scanner(System.in);
            String task = input.nextLine();
            
            switch (task) {
                case "0":
                    System.out.println("<--- Выход из программы --->");
                    repeat = false;
                    break;
                    
                case "1":
                    System.out.println("<--- Добавить новую книгу --->");
                    Book book = man.createBook();
                    man.addBook(book, books);
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
                    break;

                case "2":
                    System.out.println("<--- Cписок книг --->");
                    man.printBooksList(books);
                    break;
                    
                case "3":
                    System.out.println("<--- Зарегестрировать пользователя --->");
                    Reader reader = new Reader();
                    readerManager.addReader(reader, readers);
                    
                    ReadSaver readSaver = new ReadSaver();
                    readSaver.saveReaders(readers);
                    break;
                
                case "4":
                    System.out.println("<--- Список пользователей --->");
                    readerManager.printReadersList(readers);
                    break;
                    
                case "5":
                    System.out.println("<--- Выдача книги --->");
                    HistoryManager historyManager = new HistoryManager();
                    
                    System.out.println("<--- Список книг --->");
                    man.printBooksList(books);
                    
                    System.out.println("Выберите номер книги: ");
                    int bookNumber = input.nextInt();
                    Book book1 = books[bookNumber - 1];
                    System.out.println("<--- Список пользователей --->");
                    readerManager.printReadersList(readers);
                    int readerNumber = input.nextInt();
                    Reader reader1 = readers[readerNumber - 1];
                    Calendar c = new GregorianCalendar();
                    c.getTime();
                    History history = new History();
                    history.setBook(book1);
                    history.setReader(reader1);
                    history.setTakeOnDate(c.getTime());
                    HistoryManager.addHistory(history, histories);

                    HistorySaver historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    System.out.println("Читателю " + history.getReader().getSurname() + " выдана книга " + history.getBook().getName());
                    break;

                case "6":
                    System.out.println("<--- Вернуть книгу в библиотеку --->");
                    System.out.println("<--- Список читаемых книг --->");
                    man.printBooksList(books);
                    System.out.println("Выберите номер возращаемой книги: ");
                    int historyNumber = input.nextInt();
                    c = new GregorianCalendar();
                    histories[(historyNumber - 1)].setReturnDate(c.getTime());
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    break;
                    
                case "7":
                    System.out.println("<--- Список читаемых книг --->");
                    BookRead bookRead = new BookRead();
                    bookRead.printListReadBooks(histories);
                    break;

                default:
                    System.out.println("<--- Такой задачи нет! --->");
            }
        }while(repeat);
    }
    
}
