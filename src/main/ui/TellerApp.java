package ui;

import model.AccountManage;
import model.Data;
import model.Food;
import org.json.JSONObject;


import java.io.*;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

// Calculator teller application
public class TellerApp {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private Scanner input;
    private AccountManage vip;

    // EFFECTS: runs the teller application
    public TellerApp() throws FileNotFoundException {
        runTeller();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTeller() throws FileNotFoundException {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        init();
        getDataFromFile("data");
        //System.out.println(stringToJson().get("age"));
        loadData();


        //loadAccounts();

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
    // MODIFIES: this
    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
    // otherwise initializes accounts with default values

//    private void loadAccounts() {
//        try {
//            List<AccountManage> accountManage = Reader.readAccounts(new File(ACCOUNTS_FILE));
//            vip = accountManage.get(0);
//        } catch (IOException e) {
//            init();
//        }
//    }

    public String getDataFromFile(String fileName) {

        String path = "d:\\" + fileName + ".json";
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
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
        //System.out.println(laststr);
        return laststr;
    }

    public JSONObject stringToJson() {
        String stringData = getDataFromFile("data");
        JSONObject jsonData = new JSONObject(stringData);
        return jsonData;
    }

    public void loadData() {
        Integer age = stringToJson().getInt("age");
        int height = stringToJson().getInt("height");
        int weight = stringToJson().getInt("weight");
        String needs = stringToJson().getString("needs");
        Data data = new Data();
        data.setAge(age);
        data.setHeight(height);
        data.setWeight(weight);
        data.setRequire(needs);
        vip.setData(data);

    }


    // EFFECTS: saves state of owner's accounts to ACCOUNTS_FILE
//    private void saveAccounts() {
//        try {
//            Writer writer = new Writer(new File(ACCOUNTS_FILE));
//            writer.write(vip);
//            writer.close();
//            System.out.println("Accounts saved to file " + ACCOUNTS_FILE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save accounts to " + ACCOUNTS_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            // this is due to a programming error
//        }
//    }


    public void saveDataToFile(String fileName, String data) {
        BufferedWriter writer = null;
        File file = new File("d:\\" + fileName + ".json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) throws FileNotFoundException {
        if (command.equals("d")) {
            modifyData();
        } else if (command.equals("i")) {
            insertFood();
        } else if (command.equals("c")) {
            calculateCalories();
        } else if (command.equals("s")) {
            saveDataToFile("data",vip.jsonToString());
        } else if (command.equals("p")) {
            printAccount();
        }  else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> modifyData");
        System.out.println("\ti -> insertFood");
        System.out.println("\tc -> calculateCalories");
        System.out.println("\ts -> save accounts to file");
        System.out.println("\tp -> print to screen");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        vip = new AccountManage("", "");
    }

    private void modifyData() {
        System.out.println("Enter your age :");
        vip.getData().setAge(parseInt(input.nextLine()));
        System.out.println("Enter your height");
        vip.getData().setHeight(parseDouble(input.nextLine()));
        System.out.println("Enter your weight");
        vip.getData().setWeight(parseDouble(input.nextLine()));
        System.out.println("Enter your needs, add or lose");
        vip.getData().setRequire(input.nextLine());
    }


    private void insertFood() {
        Food newFood = new Food("", 0);
        System.out.println("Enter the food you ate :");
        newFood.setName(input.nextLine());
        System.out.println("Enter the cal of the food:");
        newFood.setCalories(parseInt(input.nextLine()));
        System.out.println("Enter the quantity of the food");
        vip.addFood(newFood, parseInt(input.nextLine()));
    }

    private void calculateCalories() {
        System.out.println("calculate basalMetabolism :");
        System.out.println(vip.basalMetabolism());
        System.out.println("calculate intakeCalories :");
        System.out.println(vip.countIntakeCalories());
        System.out.println("total calories :");
        System.out.println(vip.totalCalories());
    }

    // EFFECTS: prompts user to select an account and prints account to screen
    private void printAccount() {
        System.out.println("Account holder: " + vip.getName() + "\n");
        System.out.println("Account holder's sex: " + vip.getSex());
        System.out.println(("Account holder's age:" + vip.getData().getAge()));
        System.out.println(("Account holder's height:" + vip.getData().getHeight()));
        System.out.println(("Account holder's weight:" + vip.getData().getWeight()));
        System.out.println(("Account holder's needs:" + vip.getData().getRequire()));
    }





}
