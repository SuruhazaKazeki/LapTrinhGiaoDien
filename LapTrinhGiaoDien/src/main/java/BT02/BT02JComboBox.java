package BT02;

import BT01.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class BT02JComboBox extends JFrame {

    private JLabel lbNum1, lbNum2, lbResult,lbOp ;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btTinh,btNhapLai;
    private JComboBox <String> cbbPhepTinh;

    public BT02JComboBox() {
        setTitle("Tính toán");
        createGui();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGui() {
        //Tạo thùng chứa P1
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 2, 10, 10));//set layout dạng lưới
        p.add(lbNum1 = new JLabel("Num1"));
        p.add(txtNum1 = new JTextField());
        txtNum1.setPreferredSize(new Dimension(100,30));
        p.add(lbNum2 = new JLabel("Num2"));
        p.add(txtNum2 = new JTextField());
        p.add(lbOp = new JLabel("Phép Tính"));
        p.add(cbbPhepTinh = new JComboBox<>());
        p.add(lbResult=new JLabel("Kết Quả"));
        p.add(txtResult = new JTextField(10));
        txtResult.setEditable(false);
        
        p.add(btTinh = new JButton("Tính"));
        p.add(btNhapLai = new JButton("Nhập Lại"));
        
        add(p);
        cbbPhepTinh.addItem("Cộng");
        cbbPhepTinh.addItem("Trừ");
        cbbPhepTinh.addItem("Nhân");
        cbbPhepTinh.addItem("Chia");
       

        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    int selectedIndex = cbbPhepTinh.getSelectedIndex();
                    if (selectedIndex ==0) {
                        kq = x + y;
                    } else if (selectedIndex == 1) {
                        kq = x - y;
                    } else if (selectedIndex ==2) {
                        kq = x * y;
                    } else {
                        kq = x / y;
                    }
                    txtResult.setText(String.valueOf(kq));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Loi nhap lieu", "Thong bao loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
         btNhapLai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txtNum1.setText("");
                txtNum2.setText("");
                txtResult.setText("");
                cbbPhepTinh.setSelectedIndex(0);
                txtNum1.requestFocus();
            }
        });
        
    }

    public static void main(String[] args) {
        BT02JComboBox frm = new BT02JComboBox();
        frm.setVisible(true);
    }

}
