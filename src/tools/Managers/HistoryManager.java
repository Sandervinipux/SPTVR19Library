/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.Managers;

import entity.History;

/**
 *
* @author Sander Rubenkov
 */
public class HistoryManager {

    public static void addHistory(History history, History[] histories) {
        for (int i = 0; i < histories.length; i++){
            if(histories[i] == null){
                histories[i] = history;
                break;
            }
        }
    }
    
}
