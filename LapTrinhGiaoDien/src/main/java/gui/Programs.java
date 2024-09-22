package gui;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Programs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frm = new JFrame ("Login System");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,2,10,10));
        JLabel lbUser = new JLabel ("User neame");
        JLabel lbPass = new JLabel ("Password");
        
        JTextField txtUser = new JTextField();
        JTextField txtPass = new JTextField();
        
        JButton btLogin = new JButton("Login");
        JButton btReset = new JButton("Reset");
        
        p.add(lbUser);
        p.add(lbPass);
        p.add(txtUser);
        p.add(txtPass);
        p.add(btLogin);
        p.add(btReset);
       
        frm.add(p);
        frm.setSize (300,200);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
    
}
