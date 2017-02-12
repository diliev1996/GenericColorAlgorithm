/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenericColorAlgorithm;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author viva
 */
public class Worker extends SwingWorker<Object, Object>{
    JPanel panel;
    Chromosone ch;
    public Worker(JPanel panel,Chromosone ch) {
        this.panel = panel;
        this.ch = ch;
    }
 
    @Override
    protected Object doInBackground() throws Exception {
       panel.setBackground(new Color(ch.getRed(), ch.getGreen(),ch.getBlue()));
       return panel;
    }
    
}
