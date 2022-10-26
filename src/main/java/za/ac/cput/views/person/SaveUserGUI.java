package za.ac.cput.views.person;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.http.MediaType;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.springframework.http.RequestEntity.post;

public class SaveUserGUI extends JFrame implements ActionListener {

    public static  final MediaType JSON =
            MediaType.parseMediaType("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    private JLabel lblFirstName, lblLastName, lblAddress, lblCellNumber, lblEmailAddress;
    private JTextField txtFirstName, txtLastName, txtAddress, txtCellNumber, txtEmailAddress;
    private JButton btnSave, btnCancel;
    public JPanel pN, pS;

    public SaveUserGUI() {
        super("Add new User");

        pN = new JPanel();
        pS = new JPanel();

        lblFirstName = new JLabel("First Name: ");
        lblLastName = new JLabel("Last Name: ");
        lblAddress = new JLabel("Address: ");
        lblCellNumber = new JLabel("Cell Number: ");
        lblEmailAddress = new JLabel("Email Address: ");

        txtFirstName = new JTextField(30);
        txtLastName = new JTextField(30);
        txtAddress = new JTextField(30);
        txtCellNumber = new JTextField(30);
        txtEmailAddress = new JTextField(30);

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
    }

    public void setGUI() {
        pN.setLayout(new GridLayout(0,2));
        pS.setLayout(new GridLayout(1,2));

        pN.add(lblFirstName);
        pN.add(txtFirstName);
        pN.add(lblLastName);
        pN.add(txtLastName);
        pN.add(lblAddress);
        pN.add(txtAddress);
        pN.add(lblCellNumber);
        pN.add(txtCellNumber);
        pN.add(lblEmailAddress);
        pN.add(txtEmailAddress);

        pS.add(btnSave);
        pS.add(btnCancel);

        this.add(pN, BorderLayout.NORTH);
        this.add(pS, BorderLayout.SOUTH);

        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            store(txtFirstName.getText(),
                    txtLastName.getText(),
                    txtAddress.getText(),
                    txtCellNumber.getText(),
                    txtEmailAddress.getText());
        } else if (e.getSource() == btnCancel) {
            UserHomePage.main(null);
            this.setVisible(false);
        }
    }
    public void store(String firstName, String lastName, String address, String emailAddress, String cellNumber) {
        try {
            final String URL = "http://localhost:8080/carparkingservice/user/create";
            User user = UserFactory.build(firstName,lastName,address,cellNumber,emailAddress);
            Gson g = new Gson();
            String jsonString = g.toJson(user);
            String r = String.valueOf(post(URL, jsonString));
            if (r != null) {
                JOptionPane.showMessageDialog(null, "User saved successfully!");
                UserHomePage.main(null);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Oops, The user is not saved.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
//    public String post(String url, String json)throws IOException{
//        RequestBody body = RequestBody.create(JSON), json);
//        RequestBody request = new Request.Builder().url(url).post(body).build();
//        try (Response response = client.newCall(request).execute()){
//    }
//    }
}
