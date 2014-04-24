package com.github.marschall.techzone.java8.lambda;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingSampleOld {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        JFrame frame = makeFrame();
        frame.pack();
        frame.setVisible(true);
      }
    }); 

  }
  
  static JFrame makeFrame() {
    JFrame frame = new JFrame("Java 8 AIC Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
    JButton button1 = new JButton("Button 1");
    // lambda 1
    button1.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("button 1 pressed at: " + Instant.ofEpochMilli(e.getWhen()));
      }
    });
    contentPane.add(button1);
    
    return frame;
  }
  
}
