/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Managers;

import entity.Reader;
import tools.ReadFactory;

/**
 *
* @author Sander Rubenkov
 */
public class ReaderManager {

    public void addReader(Reader reader, Reader[] readers) {
        for(int i = 0; i < readers.length; i++) {
            if (readers[i] ==  null){ 
              
                ReadFactory readFactory = new ReadFactory();
                reader = readFactory.createReader();
                readers[i] = reader;
                System.out.printf("Добавлена книга: %s%n", readers[i].getName());
                break;
            }
        }
       
    }

    public void printReadersList(Reader[] readers) {
        for (int i = 0; i < readers.length; i++){
            if(readers[i] != null){
                System.out.printf("%3d Читатель: %s %s%n", i+1, readers[i].getName(), readers[i].getSurname());
            }
        }
    }
    
}
