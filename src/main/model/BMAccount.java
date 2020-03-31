package model;


import org.json.JSONObject;

import java.io.IOException;

//Set an account for calculate BM
public class BMAccount extends Account {
    public Data accountData; //the data to store additional information of the account owner


    public BMAccount(String name, String sex) {
        super(name, sex);
        accountData = new Data();


    }

    //REQUIRES: sex have to be string "f" or "m"
    //EFFECTS: calculate basalMetabolism based on personal information
    public double basalMetabolism() throws IOException {
        if (sex.equals("f")) {
            return 9.6 * accountData.getWeight() + 1.8 * accountData.getHeight()
                    - 4.7 * accountData.getAge() + 655;
        } else if (sex.equals("m")) {
            return 13.7 * accountData.getWeight() + 5 * accountData.getHeight()
                    - 6.8 * accountData.getAge() + 66;
        } else {
            throw new IOException("Invalid Sex!");
        }
    }

//    //EFFECTS: calculate food intake calories
//    public double countIntakeCalories() {
//        double sum = 0;
//        for (FoodIntake i : foodIntakeArrayList) {
//            for (Food f : foodArrayList) {
//                int calories = f.getCalories() / 100 * i.getQuantity();
//                sum = sum + calories;
//            }
//        }
//        return sum;
//    }
//
//    //EFFECTS: calculate daily calories by basalMetabolism and food intake calories
//    public double dailyCalories() throws IOException {
//        return countIntakeCalories() - basalMetabolism();
//    }

    //EFFECTS: modify data in json to string
    public String jsonToString() throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("sex", sex);
        obj.put("age", accountData.getAge());
        obj.put("height", accountData.getHeight());
        obj.put("weight", accountData.getWeight());
        obj.put("needs", accountData.getRequire());
        obj.put("BM", basalMetabolism());

        String data1 = obj.toString();
        return data1;
    }

    // EFFECTS: returns the data for the account
    public Data getData() {
        return accountData;
    }

    //EFFECTS: set data to accountData
    public void setData(Data data) {
        accountData = data;
    }

}
