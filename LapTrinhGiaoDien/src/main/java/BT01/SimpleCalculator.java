package BT01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class SimpleCalculator extends JFrame {

    private JLabel lbNum1, lbNum2, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btAdd, btSub, btMul, btDiv,btExit;

    public SimpleCalculator(String title) {
        super(title);
        createGui();
        pack();
        //setSize (500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createGui() {
        //Tạo thùng chứa P1
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 10, 10));//set layout dạng lưới
        p1.add(lbNum1 = new JLabel("Num1"));
        p1.add(txtNum1 = new JTextField());
        p1.add(lbNum2 = new JLabel("Num2"));
        p1.add(txtNum2 = new JTextField());
        p1.add(lbResult = new JLabel("Result"));
        p1.add(txtResult = new JTextField());
        //Tạo thùng chứa P2
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());//set layout tự động FlowLayout
        p2.add(btAdd = new JButton("Add"));
        p2.add(btSub = new JButton("Sub"));
        p2.add(btMul = new JButton("Mul"));
        p2.add(btDiv = new JButton("Div"));
        p2.add(btExit = new JButton("Exit"));
        //add p1,p2 vao main window

        add(p1,BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        //phep cong
        btAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq = x+y;
                    txtResult.setText(String.valueOf(kq));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ!");
                }
            }
        });
        btSub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq = x-y;
                    txtResult.setText(String.valueOf(kq));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ!");
                }
            }
        });
        btMul.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq = x*y;
                    txtResult.setText(String.valueOf(kq));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ!");
                }
            }
        });
        btDiv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq = x/y;
                    txtResult.setText(String.valueOf(kq));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ!");
                }
            }
        });
        btExit.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            int chon = JOptionPane.showConfirmDialog(null,"Bạn có chắc đóng ứng dụng?","Close",JOptionPane.YES_NO_OPTION);
            if(chon == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        });
    }
    
    public static void main(String[] args) {
        SimpleCalculator frm = new SimpleCalculator("Simple Calculator");
        frm.setVisible(true);
    }

}
