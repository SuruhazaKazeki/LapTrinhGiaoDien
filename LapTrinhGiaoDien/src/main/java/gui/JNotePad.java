/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author Acer
 */
public class JNotePad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFormat, mView, mHelp,mZoom;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint;
    private JMenuItem itemExit, itemFont, itemStatusBar, itemViewHelp, itemSendFeedback, itemAboutNotepad; 
    private JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSwB, itemFint, itemFintNext; 
    private JMenuItem itemFintPrevious, itemReplace, itemGoTo, itemSelectAll,itemTimeDate, itemZoomIn, itemZoomOut,itemRDZoom;
    private JCheckBoxMenuItem cbStatusBar;
    private JCheckBoxMenuItem itemWrap;
    private JTextArea txtEditor;
    private JToolBar toolBar;
    private JButton btNew,btOpen,btSave;

    public JNotePad(String title) {
        super(title);
        createMenu();
        createGUI();
        processEvent();
        createToolBar();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }

    private void createMenu() {
        //Tạo thanh thực đơn
        mBar = new JMenuBar();
        //Tạo và add vào thanh thực đơn
        mBar.add(mFile = new JMenu("File"));
        mBar.add(mEdit = new JMenu("Edit"));
        mBar.add(mFormat = new JMenu("Format"));
        mBar.add(mView = new JMenu("Views"));
        mBar.add(mHelp= new JMenu("Helps"));

        //Tạo item và edd vào thanh thực đơn
        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open..."));
        mFile.add(itemSave = new JMenuItem("Save"));
        mFile.add(itemSaveAs = new JMenuItem("Save As..."));
        mFile.addSeparator();
        mFile.add(itemPageSetup = new JMenuItem("PageSetup"));
        mFile.add(itemPrint = new JMenuItem("Print..."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));
        //Tạo item và add vào Edit
        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));
        mEdit.add(itemDelete = new JMenuItem("Delete"));
        mEdit.add(itemSwB = new JMenuItem("Search with Bing"));
        mEdit.add(itemFint = new JMenuItem("Fint"));
        mEdit.add(itemFintNext = new JMenuItem("Fint Next"));
        mEdit.add(itemFintPrevious = new JMenuItem("Fint Previous"));
        mEdit.add(itemGoTo = new JMenuItem("Go To..."));
        mEdit.add(itemSelectAll = new JMenuItem("Select All"));
        mEdit.add(itemTimeDate = new JMenuItem("Time/Date"));
        
        mView.add(mZoom = new JMenu("Zoom"));
        mView.add(cbStatusBar = new JCheckBoxMenuItem("Status Bar"));
        mZoom.add(itemZoomIn = new JMenuItem("Zoom in"));
        mZoom.add(itemZoomOut = new JMenuItem("Zoom out"));
        mZoom.add(itemRDZoom = new JMenuItem("Restore Default Zoom"));
        
        //Tạo Item và add vào menu Format
        mFormat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap", true));
        mFormat.add(itemFont = new JMenuItem("Font..."));

        //tạo tổ hợp phím nóng
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));

        //Gắn thực đơn vào cửa sổ
        setJMenuBar(mBar);

        //Tiếp nhận sự kiện cho itemExit
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to exit?") == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    private void processEvent() {
        // Open functionality
        itemOpen.addActionListener(e -> openFile());

        // Save functionality
        itemSave.addActionListener(e -> saveFile(false));

        // Save As functionality
        itemSaveAs.addActionListener(e -> saveFile(true));

        // Exit functionality
        itemExit.addActionListener(e -> System.exit(0));

        // Copy functionality
        itemCopy.addActionListener(e -> txtEditor.copy());

        // Paste functionality
        itemPaste.addActionListener(e -> txtEditor.paste());

        // Word Wrap functionality
        itemWrap.addActionListener(e -> txtEditor.setLineWrap(itemWrap.isSelected()));
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                txtEditor.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
            }
        }
    }

    private void saveFile(boolean saveAs) {
        JFileChooser fileChooser = new JFileChooser();
        if (saveAs || fileChooser.getSelectedFile() == null) {
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    txtEditor.write(writer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        JNotePad notepad = new JNotePad("Demo Notepad");
        notepad.setVisible(true);

    }

    public void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollEditor = new JScrollPane(txtEditor);
        add(scrollEditor);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }
    private void createToolBar() {
        toolBar = new JToolBar();
        toolBar.add(btNew = new JButton("New"));
        toolBar.add(btOpen = new JButton ("Open"));
        toolBar.add(btSave = new JButton("Save"));
       
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/images/New.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/images/Open.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/images/Save.png")));
       
        add(toolBar, BorderLayout.NORTH);
    }

}
