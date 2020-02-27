package model;


import netscape.javascript.JSObject;
import org.json.JSONObject;

public class AccountManage extends Account {

    public AccountManage(String name, String sex) {
        super(name, sex);


    }

    public double basalMetabolism() {
        if (sex == "f") {
            double bmf = 9.6 * accountData.getWeight() + 1.8 * accountData.getHeight()
                    - 4.7 * accountData.getAge() + 655;
            return bmf;
        } else {
            double bmm = 13.7 * accountData.getWeight() + 5 * accountData.getHeight()
                    - 6.8 * accountData.getAge() + 66;
            return bmm;
        }
    }

    public double countIntakeCalories() {
        double sum = 0;
        for (FoodIntake i : foodIntakeArrayList) {
            for (Food f : foodArrayList) {
                int calories = f.getCalories() / 100 * i.getQuantity();
                sum = sum + calories;
            }
        }
        return sum;
    }

    public double totalCalories() {
        return countIntakeCalories() - basalMetabolism();
    }

    public String jsonToString() {
        JSONObject obj = new JSONObject();
        obj.put("age", accountData.getAge());
        obj.put("height", accountData.getHeight());
        obj.put("weight", accountData.getWeight());
        obj.put("needs", accountData.getRequire());

        String data1 = obj.toString();
        return data1;
    }

    public void setData(Data data) {
        accountData = data;
    }

}
