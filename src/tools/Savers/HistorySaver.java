/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Savers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
* @author Sander Rubenkov
 */
public class HistorySaver implements Serializable {
    private String fileName = "Historie";
    
   public void saveHistories(History[] histories) {
        FileOutputStream fos  = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден!");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода, вывода!");
        }
    }

    public History[] loadFile(History[] histories) {
        FileInputStream fis  = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (History[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден!");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода или вывода!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Класс не найден!");
        }
        return new History[100];
        
    }
    
}