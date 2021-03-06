package ui;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import exception.InvalidInformationException;
import model.BMAccount;
import model.Data;
import org.json.JSONObject;


import java.io.*;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

// Calculator teller application
public class TellerApp {
//    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private Scanner input;
    private BMAccount vip;
    private double value;


    // EFFECTS: runs the teller application
    public TellerApp() throws IOException, InvalidInformationException {
        runTeller();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTeller() throws IOException, InvalidInformationException {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        init();
        getDataFromFile("accountData");
        //System.out.println(stringToJson().get("age"));
        loadData();

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: return the newest information in file
    public String getDataFromFile(String fileName) {
        String path = "./data/" + fileName + ".json";
        BufferedReader reader = null;
        String lastString = "";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                lastString += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println(lastString);
        return lastString;
    }

    // EFFECTS: turn string to json
    public JSONObject stringToJson() {
        String stringData = getDataFromFile("accountData");
        if (stringData == null || stringData.isEmpty()) {
            return null;
        }
        JSONObject jsonData = new JSONObject(stringData);
        return jsonData;
    }


    // EFFECTS: loads data from json and set to accountData in accountMange
    public void loadData() {
        JSONObject json = stringToJson();
        if (json == null) {
            return;
        }
        int age = json.getInt("age");
        int height = json.getInt("height");
        int weight = json.getInt("weight");
        String needs = json.getString("needs");
        Data data = new Data();
        data.setAge(age);
        data.setHeight(height);
        data.setWeight(weight);
        data.setRequire(needs);
        vip.setData(data);
    }

    // EFFECTS: save data to file
    public void saveDataToFile(String fileName, String data) {
        BufferedWriter writer = null;
        File file = new File("./data/" + fileName + ".json");
        checkFile(file);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false),
                    "UTF-8"));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if  (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Saved done !");
    }

    // EFFECTS: check if file exists, if not create new file
    private void checkFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        try {
            if (command.equals("i")) {
                insertInformation();
            } else if (command.equals("c")) {
                System.out.println(calculateBM());
            } else if (command.equals("s")) {
                saveDataToFile("accountData",vip.jsonToString());
            } else if (command.equals("p")) {
                printAccount();
            }  else {
                System.out.println("Selection not valid...");
            }
        } catch (IOException e) {
            System.out.println("Please insert valid information!");
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Please fill out the information!");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ti -> insertInformation");
//        System.out.println("\ti -> insertFood");
        System.out.println("\tc -> calculateBM");
        System.out.println("\ts -> save accounts to file");
        System.out.println("\tp -> print to screen");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() throws InvalidInformationException {
        vip = new BMAccount("", "");
    }

    // EFFECTS: collect insert information
    private void insertInformation() {
        try {
            System.out.println("Enter your name :");
            vip.modifyName(input.nextLine());
            System.out.println("Enter your sex :");
            vip.modifySex(input.nextLine());
            System.out.println("Enter your age :");
            vip.getData().setAge(parseInt(input.nextLine()));
            System.out.println("Enter your height");
            vip.getData().setHeight(parseDouble(input.nextLine()));
            System.out.println("Enter your weight");
            vip.getData().setWeight(parseDouble(input.nextLine()));
            System.out.println("Enter your needs, add or lose");
            vip.getData().setRequire(input.nextLine());
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Please fill out the information!");
        }
    }

    // EFFECTS: calculate BM value by using insert information
    private double calculateBM() {
        try {
            value = vip.basalMetabolism();
        } catch (IOException e) {
            System.out.println("Invalid Sex!");
        }
        return value;
    }



    // EFFECTS: prompts user to select an account and prints account to screen
    private void printAccount() {
        try {
            System.out.println("Account holder: " + vip.getName());
            System.out.println("Account holder's sex: " + vip.getSex());
            System.out.println("Account holder's age:" + vip.getData().getAge());
            System.out.println("Account holder's height:" + vip.getData().getHeight());
            System.out.println("Account holder's weight:" + vip.getData().getWeight());
            System.out.println("Account holder's needs:" + vip.getData().getRequire());
            System.out.println("Account holder's BM:" + vip.basalMetabolism());
        } catch (NullPointerException e) {
            System.out.println("Please fill out the information!");
        } catch (InvalidInformationException | IOException e) {
            System.out.println("Please insert valid information!");
        }
    }





}
