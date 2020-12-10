/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
* @author Sander Rubenkov
 */
public class Reader implements Serializable {
    private String name;
    private String surname;
    private String numPhone;

    public Reader(String name, String surname, String numPhone) {
        this.name = name;
        this.surname = surname;
        this.numPhone = numPhone;
    }

    public Reader() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    @Override
    public String toString() {
        return "Read{" 
                + "name=" + name 
                + ", surname=" + surname 
                + ", numPhone=" + numPhone 
                + '}';
    }
    
    
}

