package ui;


import exception.InvalidInformationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


/*
 * Represents the main window for calories calculator
 *
 */
@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField sexField;
    private JTextField ageField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextField requireField;
    private String operation;
    private AccountManage vip;
    private Data vipData;
    private JTextArea jta;


    // EFFECTS: display the main window which is
    // the login in page
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
        addOnPanel1(panel1, btn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // EFFECTS: add labels and text field on panel1
    private void addOnPanel1(JPanel panel1, JButton btn) {
        JLabel nameLabel = new JLabel("Username:");
        //nameLabel.setBounds(10,20,80,25);
        nameField = new JTextField(10);
        //nameField.setBounds(100,20,165,25);
        JLabel sexLabel = new JLabel("Sex:");
        //sexLabel.setBounds(10,60,80,25);
        sexField = new JTextField(10);
        //sexField.setBounds(100,60,165,25);
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(sexLabel);
        panel1.add(sexField);
        panel1.add(btn);
    }

    // MODIFIES: this
    // EFFECTS:  set an account with name and sex get from fields
    //           and collect information for account data from the second window
    public void setAccount() throws InvalidInformationException {
        String accountName = nameField.getText();
        String accountHolderSex = sexField.getText();
        vip = new AccountManage(accountName, accountHolderSex);
        vipData = new Data();
        vip.setData(vipData);
    }

    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("myLogin")) {
                setAccount();
                operationFirstPerformed();
                playMusic();
            } else if (e.getActionCommand().equals("myCalculator")) {
                operationSecondPerformed();
            } else if (e.getActionCommand().equals("mySave")) {
                operationThirdPerformed();
            } else if (e.getActionCommand().equals("myLoad")) {
                operationFourthPerformed();
            }
        } catch (InvalidInformationException | IOException ex) {
            ex.printStackTrace();
        }
    }


    // EFFECTS:  perform this operation when login button be clicked
    public void operationFirstPerformed() {
        try {
            win2();
            new InfoWin().infoWin(" Your Name is " + vip.getName() + "\n" + "Your Sex is " + vip.getSex());
        } catch (NullPointerException e) {
            new InfoWin().infoWin("Please fill out the information!");
        } catch (InvalidInformationException e) {
            new InfoWin().infoWin("Invalid Sex! Please try again !");
        }
    }

    // EFFECTS:  perform this operation when calculate button be clicked
    public void operationSecondPerformed() {
        try {
            Integer holderAge = Integer.parseInt(ageField.getText());
            double holderWeight = Double.parseDouble(weightField.getText());
            double holderHeight = Double.parseDouble(heightField.getText());
            String holderRequire = requireField.getText();
            vipData.setAge(holderAge);
            vipData.setWeight(holderWeight);
            vipData.setHeight(holderHeight);
            vipData.setRequire(holderRequire);
            new InfoWin().infoWin("Your Age is " + vipData.getAge() + "\n"
                    + " Your Weight is  " + vipData.getWeight() + "\n"
                    + "Your Height is " + vipData.getHeight() + "\n"
                    + "Your Personal Needs is " + vipData.getRequire() + "\n"
                    + "Your Daily Basal Metabolism is " + vip.basalMetabolism());
        } catch (NumberFormatException | IOException e) {
            new InfoWin().infoWin("Insufficient Information! Please fill out !");
        }

    }

    // EFFECTS:  perform this operation when save button be clicked
    public void operationThirdPerformed() {
        try {
            String accountName = nameField.getText();
            String accountHolderSex = sexField.getText();
            String age = ageField.getText();
            String weight = weightField.getText();
            String height = heightField.getText();
            String require = requireField.getText();
            String basalMetabolism = String.valueOf(vip.basalMetabolism());
            FileWriter fw  = new FileWriter("./data/" + accountName + ".txt");
            fw.write(accountName +  "\n" + accountHolderSex + "\n" + age + "\n" + weight + "\n"
                    + height + "\n" + require + "\n" + basalMetabolism);
            fw.close();
            new InfoWin().infoWin("Save done !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: display the load text window for account information
    private void win3() {
        JFrame frame3 = new JFrame("Personal Information");
        JPanel panel3 = new JPanel(true);
        frame3.add(panel3);
        frame3.setBounds(300, 300, 300, 300);
        jta = new JTextArea(5,15);
        panel3.add(jta);
        frame3.setVisible(true);
        frame3.setResizable(true);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //原文链接：https://blog.csdn.net/mrliqifeng/article/details/72885486 （CSDN）「李奇峰1998」


    // EFFECTS:  perform this operation when load button be clicked
    public void operationFourthPerformed() throws IOException {
        try {
            String accountName = nameField.getText();
            FileReader fr = new FileReader("./data/" + accountName + ".txt");
            BufferedReader br = new BufferedReader(fr);
            win3();
            String s = null;
            while ((s = br.readLine()) != null) {
                jta.append(s);
                jta.append("\n");
            }
        } catch (FileNotFoundException e1) {
            new InfoWin().infoWin("Cannot find that person, please save first!");
        }
    }


    // EFFECTS: display the second window to collect information for account data
    //          and the buttons for calculate, save and load.
    public void win2() {
        //frame.setVisible(false);
        JFrame frame2 = new JFrame("Data Collector");
        JPanel panel = new JPanel(true);
        frame2.add(panel);
        frame2.setBounds(500, 500, 400, 500);
        JButton btn2 = new JButton("Calculate");
        btn2.setActionCommand("myCalculator");
        btn2.addActionListener(this);
        JButton btn3 = new JButton("Save");
        btn3.setActionCommand("mySave");
        btn3.addActionListener(this);
        JButton btn4 = new JButton("Load");
        btn4.setActionCommand("myLoad");
        btn4.addActionListener(this);
        addOnPanel2(panel);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        frame2.setVisible(true);
        frame2.setResizable(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // EFFECTS: add labels and text field on panel2 for the second window
    private void addOnPanel2(JPanel panel) {
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(10);
        JLabel weightLabel = new JLabel("Weight:");
        weightField = new JTextField(10);
        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);
        JLabel requireLabel = new JLabel("Require:");
        requireField = new JTextField(10);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(requireLabel);
        panel.add(requireField);
    }

    // EFFECTS: play background music when login button been pressed
    public void playMusic() {
        try {
            FileInputStream fileau = new FileInputStream("./data/" + "backgroundmusic.wav");
            AudioStream as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Main();
    }

}
