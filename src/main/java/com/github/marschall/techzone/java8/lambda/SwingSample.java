package com.github.marschall.techzone.java8.lambda;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.time.Instant;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingSample {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = makeFrame();
      frame.pack();
      frame.setVisible(true);
    }); 

  }
  
  static JFrame makeFrame() {
    JFrame frame = new JFrame("Java 8 \u03BB Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    JButton button1 = new JButton("Button 1");
    // lambda 1
    button1.addActionListener((ActionEvent e) -> {
      System.out.println("button 1 pressed at: " + Instant.ofEpochMilli(e.getWhen()));}
    );
    contentPane.add(button1);
    
    JButton button2 = new JButton("Button 2");
    // lambda 2
    button2.addActionListener((e) -> 
      System.out.println("button 2 pressed at: " + Instant.ofEpochMilli(e.getWhen()))
    );
    contentPane.add(button2);
    
    JButton button3 = new JButton("Button 3");
    // method reference 1
    button3.addActionListener(SwingSample::button3Pressed);
    contentPane.add(button3);
    
    ActionController controller = new ActionController();
    JButton button4 = new JButton("Button 4");
    // method reference 2
    button4.addActionListener(controller::button4Pressed);
    contentPane.add(button4);
    
    return frame;
  }
  
  static void button3Pressed(ActionEvent event) {
    System.out.println("button 3 pressed at: " + Instant.ofEpochMilli(event.getWhen()));
  }
  
  static final class ActionController {
    
    void button4Pressed(ActionEvent event) {
      System.out.println("button 4 pressed at: " + Instant.ofEpochMilli(event.getWhen()));
    }
    
  }

}
