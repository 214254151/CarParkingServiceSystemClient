package za.ac.cput.views;

import za.ac.cput.views.person.UserHomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    private JButton btnCampus, btnSchedule,
            btnUser, btnDepartment, btnParkingLot, btnParkingSpace, btnVehicle,
            btnPayment, btnReservation, btnReservationStatus, btnRole;

    private JLabel lblHeading;
    private JPanel pnN, pnC;
    public Font fnt;

    public HomePage() {

        super("Car Parking Service System");

        pnN = new JPanel();
        pnC = new JPanel();

        btnCampus = new JButton("Campus");
        btnSchedule = new JButton("Schedule");
        btnUser = new JButton("User");
        btnParkingLot = new JButton("ParkingLot");
        btnDepartment = new JButton("Department");
        btnParkingSpace = new JButton("ParkingSpace");
        btnVehicle = new JButton("Vehicle");
        btnPayment = new JButton("Payment");
        btnReservation = new JButton("Reservation");
        btnReservationStatus = new JButton("ReservationStatus");
        btnRole = new JButton("Role");



        lblHeading = new JLabel("Home Page", SwingConstants.CENTER);

        fnt = new Font("Arial", Font.BOLD, 30);
    }

    public void setGUI() {

        pnN.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnC.setLayout(new GridLayout(11, 1));

        this.setPreferredSize(new Dimension(600, 600));

        lblHeading.setFont(fnt);

        pnN.add(lblHeading);

        pnC.add(btnCampus);
        pnC.add(btnSchedule);
        pnC.add(btnUser);
        pnC.add(btnDepartment);
        pnC.add(btnParkingLot);
        pnC.add(btnParkingSpace);
        pnC.add(btnVehicle);
        pnC.add(btnPayment);
        pnC.add(btnReservation);
        pnC.add(btnReservationStatus);
        pnC.add(btnRole);

        this.add(pnN, BorderLayout.NORTH);
        this.add(pnC, BorderLayout.CENTER);

        btnCampus.addActionListener(this);
        btnSchedule .addActionListener(this);
        btnDepartment.addActionListener(this);
        btnUser.addActionListener(this);
        btnParkingLot.addActionListener(this);
        btnParkingSpace.addActionListener(this);
        btnVehicle.addActionListener(this);
        btnPayment.addActionListener(this);
        btnReservation.addActionListener(this);
        btnReservationStatus.addActionListener(this);
        btnRole.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Campus":
               // CampusHomePage.main(null);
                this.setVisible(false);
                break;
            case "Schedule":
               // ScheduleHomePage.main(null);
                this.setVisible(false);
                break;
            case "Department":
               // DepartmentHomePage.main(null);
                this.setVisible(false);
                break;
            case "User":
                UserHomePage.main(null);
                this.setVisible(false);
                break;
            case "ParkingLot":
               // ParkingLotHomePage.main(null);
                this.setVisible(false);
                break;
            case "ParkingSpace":
              //  ParkingSpaceHomePage.main(null);
                this.setVisible(false);
                break;
            case "Vehicle":
               // VehicleHomePage.main(null);
                this.setVisible(false);
                break;
            case "Reservation":
               // ReservationHomePage.main(null);
                this.setVisible(false);
                break;
            case "ReservationStatus":
                //ReservationStatusHomePage.main(null);
                this.setVisible(false);
                break;
            case "Role":
               // RoleHomePage.main(null);
                this.setVisible(false);
                break;
            case "payment":
                //PaymentHomePage.main(null);
                this.setVisible(false);
                break;
        }
    }
    public static void main(String[] args) {
        new HomePage().setGUI();
    }
}
