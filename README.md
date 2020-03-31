# Basal Metabolism Calculator


## Shuhan Yang

*User* guideline :
- Create an account with your name and sex press login button.
- Fill your personal information. 
- Calculate your BM by pressing calculate button. 
- Save your account to a file with your name by pressing save button.
- Load your account by login in account with your name and pressing load button. ``


This project is a BM calculator which can calculate the basal metabolism for each person. The application could be used 
for everyone, especially for people who would like to stay health, Knowing BM could help them adjust their lifestyle, 
such as eating and exercising habit. The idea for this project comes from myself. Since I am trying to lose my weight, 
knowing the BM of myself could help me understand how much basic energy I consume daily and control my food intake and 
exercise. Hope Basal Metabolism Calculator could help more people like me!

## User Stories

As a user, I want to be able to build my account with name and sex.  
As a user, I want to be able to add my personal information to data of account.   
As a user, I want to be able to save my account information to a file  
As a user, I want to be able to optionally load  my information from data file.  

## Instructions for Grader

You can generate the first required event by inserting your name and sex ("f" for female, "m" for male) and press login button.  
You can generate the second required event by inserting your age, weight, height, and require ("add" weight or "lose") and 
press calculate button to calculate your basal metabolism.  
You can trigger my audio component by pressing login button.  
You can save the file of your name by pressing save button and check the file in data (your name).txt file.  
You can reload your information by clicking load, if the person has not been saved, the system will remind you to save first.

## Phase4 Task2

- Account class getName and getSex method have a robust design. 
- AccountManage class basalMetabolism method has a robust design. 
- AccountManage extend Account class.

## Phase4 Task3

- Change name of class AccountManage to BMAccount, which is more appropriate for the function of this class. 
- Move Data to from Account to BMAccount for cohesion. Account just contain name and sex. 
- Add the BM calculator in TellerApp, which can also calculate BM in intellij command window.

## Regrade for phase1 

You can run project and check at command window, the file for saving named "accountData" in data package. 