/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusablemenu.abstractions;

public interface IMenuItem {
    String getText();
    int getShortCut();    
    void render();
    void execute();
}
