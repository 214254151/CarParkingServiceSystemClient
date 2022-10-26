package za.ac.cput.views.person;

import za.ac.cput.views.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHomePage extends JFrame implements ActionListener {
    private JButton btnDisplay;
    private JButton btnAdd, btnUpdate;
    private JButton btnDelete, btnExit;
    private JLabel lblHeading;
    private JPanel panelNorth, panelCenter, panelSouth;
    private Font fnt;

    public UserHomePage() {
        super("User Main Page");

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        btnAdd = new JButton("Add User");
        btnUpdate = new JButton("Update User");
        btnDisplay = new JButton("Display All Users");
        btnDelete = new JButton("Delete User");
        btnExit = new JButton("Exit");

        lblHeading = new JLabel("Select a Button for User", SwingConstants.CENTER);

        fnt = new Font("Arial", Font.BOLD, 35);
    }
    public void setGUI() {
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelCenter.setLayout(new GridLayout(4, 1));
        panelSouth.setLayout(new GridLayout(1, 1));

        this.setPreferredSize(new Dimension(500, 600));
        lblHeading.setFont(fnt);
        panelNorth.add(lblHeading);
        panelCenter.add(btnAdd);
        panelCenter.add(btnUpdate);
        panelCenter.add(btnDisplay);
        panelCenter.add(btnDelete);
        panelSouth.add(btnExit);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnDisplay.addActionListener(this);
        btnAdd .addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd){
            dispose();
            new SaveUserGUI().setGUI();
        }else if(e.getSource()==btnDisplay){
            dispose();
           // new GetAllUsers().setGUI();
        }else if(e.getSource()==btnUpdate){
            dispose();
            //new UpdateUser().setGUI();
        }else if(e.getSource()==btnDelete){
            dispose();
           // new DeleteUser().setGUI();
        }else if(e.getSource()==btnExit){
            this.dispose();
            new HomePage().setGUI();
        }
    }
    public static void main(String[] args) {
        new UserHomePage().setGUI();
    }
}
