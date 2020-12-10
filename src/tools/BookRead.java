/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.History;

/**
 *
* @author Sander Rubenkov
 */
public class BookRead {

    public void printListReadBooks(History[] histories) {
        for(int i = 0; i < histories.length; i++){
            if(histories[i] != null 
                    && histories[i].getReturnDate() == null){
                System.out.printf("%d. Книгу \"%s\" читает %s %s%n",
                        i+1,
                        histories[i].getBook().getName(), 
                        histories[i].getReader().getName(), 
                        histories[i].getReader().getSurname());
            }
        }
    }
}
