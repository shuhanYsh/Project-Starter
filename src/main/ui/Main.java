package ui;

import com.sun.org.apache.xpath.internal.operations.Operation;
import exception.InvalidInformationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel sexLabel;
    private JTextField sexField;
    private String accountName;
    private String accountHolderSex;
    public JFrame frame1;
    public JPanel panel1;
    private JLabel ageLabel;
    private JLabel weightLabel;
    private JLabel heightLabel;
    private JLabel requireLabel;
    private JTextField ageField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextField requireField;
    private Integer holderAge;
    private double holderWeight;
    private double holderHeight;
    private String holderRequire;
    private String operation;
    private AccountManage vip;
    private Data vipData;




    public Main() {
        super("The Calories Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        JPanel panel1 = new JPanel();
        add(panel1);
        panel1.setLayout(new FlowLayout());
        JButton btn = new JButton("login");
        btn.setActionCommand("myLogin");
        btn.addActionListener(this);
        nameLabel = new JLabel("Username:");
        //nameLabel.setBounds(10,20,80,25);
        nameField = new JTextField(10);
        //nameField.setBounds(100,20,165,25);
        sexLabel = new JLabel("Sex:");
        //sexLabel.setBounds(10,60,80,25);
        sexField = new JTextField(10);
        //sexField.setBounds(100,60,165,25);
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(sexLabel);
        panel1.add(sexField);
        panel1.add(btn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public void secondActionPerformed(ActionEvent ee) {
//        if (ee.getActionCommand().equals("myCalculator")) {
//            AccountManage vip = new AccountManage(accountName, accountHolderSex);
//            Data vipData = new Data();
//            holderAge = Integer.parseInt(ageField.getText());
//            holderWeight = Double.parseDouble(weightField.getText());
//            holderHeight = Double.parseDouble(heightField.getText());
//            holderRequire = requireField.getText();
//            vipData.setAge(holderAge);
//            vipData.setWeight(holderWeight);
//            vipData.setHeight(holderHeight);
//            vipData.setRequire(holderRequire);
//            vip.setData(vipData);
//            new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());
//        }
//    }

    //This is the method that is called when the the JButton btn is clicked
//    public void actionPerformed(ActionEvent e) {
//        accountName = nameField.getText();
//        accountHolderSex = sexField.getText();
//        AccountManage vip = new AccountManage(accountName, accountHolderSex);
////        Data vipData = new Data();
//        if (e.getActionCommand().equals("myLogin")) {
//            new Main().win2();
//            new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());
//            accountName = nameField.getText();
//            accountHolderSex = sexField.getText();
//            ActionEvent ee = null;
//            secondActionPerformed(ee);
//        } else if (e.getActionCommand().equals("myCalculator")) {
//            AccountManage vip = new AccountManage(accountName, accountHolderSex);
//            Data vipData = new Data();
//            holderAge = Integer.parseInt(ageField.getText());
//            holderWeight = Double.parseDouble(weightField.getText());
//            holderHeight = Double.parseDouble(heightField.getText());
//            holderRequire = requireField.getText();
//            vipData.setAge(holderAge);
//            vipData.setWeight(holderWeight);
//            vipData.setHeight(holderHeight);
//            vipData.setRequire(holderRequire);
//            vip.setData(vipData);
//            new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());
//            new InfoWin().infoWin(" Your Daily Basal Metabolism is " + vipData.getAge());
//            try {
//                new InfoWin().infoWin(" Your Daily Basal Metabolism is" + vip.basalMetabolism());
//            } catch (InvalidInformationException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    public void setAccount() throws InvalidInformationException {
        accountName = nameField.getText();
        accountHolderSex = sexField.getText();
        vip = new AccountManage(accountName, accountHolderSex);
        vipData = new Data();
        vip.setData(vipData);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myLogin")) {
            operation = "login";
        } else if (e.getActionCommand().equals("myCalculator")) {
            operation = "calculate";
        }
        try {
            setAccount();
            operationPerformed(operation);
        } catch (InvalidInformationException ex) {
            ex.printStackTrace();
        }
    }


    private void operationPerformed(String operation) throws InvalidInformationException {
//        accountName = nameField.getText();
//        accountHolderSex = sexField.getText();
//        AccountManage vip = new AccountManage(accountName, accountHolderSex);
//        Data vipData = new Data();
//        vip.setData(vipData);
        switch (operation) {
            case "login":
                try {
                    new Main().win2();
                    new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());

                } catch (InvalidInformationException e) {
                    new InfoWin().infoWin("Invalid Sex! Please try again !");
                }
            case "calculate":
//                try {
                holderAge = Integer.parseInt(ageField.getText());
                holderWeight = Double.parseDouble(weightField.getText());
                holderHeight = Double.parseDouble(heightField.getText());
                holderRequire = requireField.getText();
                vipData.setAge(holderAge);
                vipData.setWeight(holderWeight);
                vipData.setHeight(holderHeight);
                vipData.setRequire(holderRequire);
                new InfoWin().infoWin(" Your Daily Basal Metabolism is " + vip.getName());
//                } catch (InvalidInformationException e) {
//                    new InfoWin().infoWin("Invalid Information! Please try again !");
//                }
        }
    }


    public void win2() {
        //frame.setVisible(false);
        JFrame frame2 = new JFrame("Data Collector");
        JPanel panel = new JPanel(true);
        frame2.add(panel);
        frame2.setBounds(500, 500, 400, 500);
        JButton btn2 = new JButton("Calculate");
        btn2.setActionCommand("myCalculator");
        btn2.addActionListener(this);
        ageLabel = new JLabel("Age:");
        //nameLabel.setBounds(10,20,80,25);
        ageField = new JTextField(10);
        //nameField.setBounds(100,20,165,25);
        weightLabel = new JLabel("Weight:");
        //sexLabel.setBounds(10,60,80,25);
        weightField = new JTextField(10);
        //sexField.setBounds(100,60,165,25);
        heightLabel = new JLabel("Height:");
        //sexLabel.setBounds(10,60,80,25);
        heightField = new JTextField(10);
        //sexField.setBounds(100,60,165,25);
        requireLabel = new JLabel("Require:");
        //sexLabel.setBounds(10,60,80,25);
        requireField = new JTextField(10);
        //sexField.setBounds(100,60,165,25);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(requireLabel);
        panel.add(requireField);
        panel.add(btn2);
        frame2.setVisible(true);
        frame2.setResizable(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public void infoWin(String message) {
//        JOptionPane.showMessageDialog(null, message);
//    }
//
//    public void secondActionPerformed(ActionEvent ee) {
//        if (ee.getActionCommand().equals("myCalculator")) {
//            AccountManage vip = new AccountManage(accountName, accountHolderSex);
//            Data vipData = new Data();
//            holderAge = Integer.parseInt(ageField.getText());
//            holderWeight = Double.parseDouble(weightField.getText());
//            holderHeight = Double.parseDouble(heightField.getText());
//            holderRequire = requireField.getText();
//            vipData.setAge(holderAge);
//            vipData.setWeight(holderWeight);
//            vipData.setHeight(holderHeight);
//            vipData.setRequire(holderRequire);
//            vip.setData(vipData);
//            new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());
//        }
//    }



    public static void main(String[] args) {
        new Main();
    }

}
