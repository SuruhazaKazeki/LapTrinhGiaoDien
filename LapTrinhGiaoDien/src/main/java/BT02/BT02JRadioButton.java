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
public class BT02JRadioButton extends JFrame {

    private JLabel lbNum1, lbNum2, lbResult,lbOp ;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btTinh,btNhapLai;
    private JRadioButton rbAdd, rbSub, rbMul, rbDiv;

    public BT02JRadioButton() {
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
       
        //Tạo thùng chứa P2
        JPanel pPT = new JPanel();
        pPT.add(rbAdd = new JRadioButton("+"));
        pPT.add(rbSub = new JRadioButton("-"));
        pPT.add(rbMul = new JRadioButton("*"));
        pPT.add(rbDiv = new JRadioButton("/"));
    
        p.add(lbOp = new JLabel("Phép Tính"));
        p.add(pPT);
        
        p.add(lbResult=new JLabel("Kết Quả"));
        p.add(txtResult = new JTextField(10));
        
        p.add(btTinh = new JButton("Tính"));
        p.add(btNhapLai = new JButton("Nhập Lại"));
        
        add(p);
        
        ButtonGroup btPhepTinh = new ButtonGroup();
        btPhepTinh.add(rbAdd);
        btPhepTinh.add(rbSub);
        btPhepTinh.add(rbMul);
        btPhepTinh.add(rbDiv);

        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq;
                    if (rbAdd.isSelected()) {
                        kq = x + y;
                    } else if (rbSub.isSelected()) {
                        kq = x - y;
                    } else if (rbMul.isSelected()) {
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
                rbAdd.setSelected(true);
                txtNum1.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        BT02JRadioButton frm = new BT02JRadioButton();
        frm.setVisible(true);
    }

}
