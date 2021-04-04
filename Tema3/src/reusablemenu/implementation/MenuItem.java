/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusablemenu.implementation;

import reusablemenu.abstractions.IExecutableAction;
import reusablemenu.abstractions.IMenuItem;


public class MenuItem implements IMenuItem {
    private final String text;
    private final int shortCut;
    private final IExecutableAction actionToExecute;

    @Override
    public int getShortCut() {
        return shortCut;
    }

    public IExecutableAction getActionToExecute() {
        return actionToExecute;
    }
    
    public MenuItem(String text, int shortCut, IExecutableAction actionToExecute)
    {
        this.text = text;
        this.shortCut = shortCut;
        this.actionToExecute = actionToExecute;
    }
    
    @Override
    public void render()
    {
        System.out.println(""+ shortCut + ". " + text);
    }
    
    @Override
    public void execute()
    {
        if(actionToExecute != null)
        {
            actionToExecute.execute(new Object[]{this});
        }
    }

    @Override
    public String getText() {
        return text;
    }
}

