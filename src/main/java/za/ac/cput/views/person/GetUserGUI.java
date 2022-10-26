//package za.ac.cput.views.person;
//
//import com.google.gson.Gson;
//import okhttp3.OkHttpClient;
//import za.ac.cput.entity.User;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//import static org.apache.logging.log4j.util.LambdaUtil.getAll;
//import static sun.security.pkcs12.PKCS12KeyStore.RetryWithZero.run;
//
//public class GetUserGUI extends JFrame implements ActionListener {
//
//    private static OkHttpClient client = new OkHttpClient();
//
//    private JTable table;
//    private JPanel pnC, pnS;
//    private JButton btnBack;
//
//    public GetUserGUI() {
//        super("All User");
//        table = new JTable();
//
//        pnC = new JPanel();
//        pnS = new JPanel();
//
//        btnBack = new JButton("Back");
//    }
//    public void setGUI() {
//        pnC.setLayout(new GridLayout(1,1));
//        pnS.setLayout(new GridLayout(1,1));
//
//        pnC.add(table);
//        pnS.add(btnBack);
//
//        this.add(pnC, BorderLayout.CENTER);
//        this.add(pnS, BorderLayout.SOUTH);
//
//        btnBack.addActionListener(this);
//
//        getAll();
//        table.setRowHeight(30);
//        this.add(new JScrollPane(table));
//        this.pack();
//        this.setSize(1000, 450);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//    }
//    public void getAll() {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.addColumn("Student ID");
//        model.addColumn("First Name");
//        model.addColumn("Last Name");
//        model.addColumn("Age");
//        model.addColumn("Email Address");
//        model.addColumn("Phone Number");
//
//        try {
//            final String URL = "http://localhost:8080/user/getall";
//            String responseBody = run(URL);
//            JSONArray students = new JSONArray(responseBody);
//
//            for (int i = 0; i < students.length(); i++) {
//                JSONObject student = students.getJSONObject(i);
//
//                Gson g = new Gson();
//                User user = g.fromJson(student.toString.(), User.class);
//
//                Object[] rowData = new Object[6];
//                rowData[0] = user.getUserID();
//                rowData[1] = user.getFirstName();
//                rowData[2] = user.getLastName();
//                rowData[3] = user.getAddress();
//                rowData[4] = user.getEmailAddress();
//                rowData[5] = user.getCellNumber();
//                model.addRow(rowData);
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
