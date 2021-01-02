package com.gymsystem.manager;

import com.gymsystem.Gui.GymManagementGui;
import javafx.application.Application;

import java.io.*;
import java.util.*;

import com.gymsystem.model.DefaultMember;
import com.gymsystem.model.StudentMember;
import com.gymsystem.model.SaveMember;
import com.gymsystem.model.Over60Member;
import com.gymsystem.model.Date;
import com.gymsystem.Exception.InputValidate;

public class MyGymManager implements GymManager {  //Implementation of class MyGymManager which holds all functions/methods of the system

    private static int remMemberCount;
    private static ArrayList<DefaultMember> memberList = new ArrayList<DefaultMember>();    //main arrayList of holding information of members

    private static MyGymManager myGymManager;
    private static String membershipNo;             //declaring instance variable to access inside methods
    private static String memberName;
    private static String memberGender;
    private static String memberCity;
    private static String memberContactNo;
    private static String memberWeight;
    private static String memberStartDate;


    public static ArrayList<DefaultMember> getMemberList() {     //getter setter of the arrayList to send values through classes
        return memberList;
    }

   public static void setMemberList(ArrayList<DefaultMember> memberList) {
        MyGymManager.memberList = memberList;
  }

    static Scanner in = new Scanner(System.in).useDelimiter("\n");

    public MyGymManager() {
    }

    private static void mainMenu() {                                //main menu of the console system
        System.out.println("\n--WELCOME TO MY GYM MANAGER--");
        System.out.println("\n Please Choose your action");
        System.out.println("1. Add member");
        System.out.println("2. Delete member");
        System.out.println("3. Print members");
        System.out.println("4. Sort the List");
        System.out.println("5. Open GUI");
        System.out.println("6. Exit");
    }


    private void mainDisplayMenu() throws IOException {      //Main menu options user Input
        int option = 0;
        do {
            mainMenu();

            while (!in.hasNextInt()) {      //validation of user inputs
                System.out.println("That's not a number! enter Again");
                in.next();
                mainMenu();
            }
            option = in.nextInt();
            switch (option) {           //Switch statement for the main menu
                case 1:                 //calling each methods that's overridden from the interface
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    printMembers();
                    break;
                case 4:
                    sortList();
                    break;
                case 5:
                    launchGUI();
                    break;
                case 6:
                    System.out.println("Thank you for using the system. GoodBye..");
                    System.exit(0);

                default:
                    System.out.println("Invalid input..Please enter again!");
                    mainDisplayMenu();
            }
            System.out.println();
        } while (option < 6);
    }

    private static void addDefaultInputs() throws IOException {      //calling all the common user inputs from a method

        System.out.print("Membership Number: ");            //getting user inputs of the Default member variables
        membershipNo = InputValidate.numValidation(in);     // user inputs are going through the input validation class to validate
        System.out.print("Member Name: ");                  //and handle exceptions
        memberName = InputValidate.stringValidation(in);
        System.out.print("Gender of the member: ");
        memberGender = InputValidate.stringValidation(in);
        System.out.print("Member Weight (KG): ");
        memberWeight = InputValidate.numValidation(in);
        System.out.print("Member City: ");
        memberCity = InputValidate.stringValidation(in);
        System.out.print("Member Contact Number: ");
        memberContactNo = InputValidate.numValidation(in);
        System.out.print("Membership Start Date [Year]: ");
        int year = InputValidate.integerValidation(in);
        System.out.print("Membership Start Date [Month]: ");
        int month = InputValidate.integerValidation(in);
        System.out.print("Membership Start Date [Day]: ");
        int day = InputValidate.integerValidation(in);

        Date myDate = new Date(year, month, day);   //values are passing through the constructor
        memberStartDate = myDate.getDate();
    }



    @Override
    public void addMember() {                               //member adding function
        System.out.println("You Selected : Add Member");
        System.out.println("\nSelect your member type: \n " +
                "    1.Default Member \n" +                   // asking from the user to add a member type
                "     2.Student Member \n" +
                "     3.Over 60 Member");


        while (!in.hasNextInt()) {                      //user input validation
            System.out.println("That's not a number! enter Again");
            in.next();
            addMember();
        }

        int mtype = in.nextInt();
        if ((mtype < 4) && (mtype > 0)) {

            int lines = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
                while (reader.readLine() != null) {
                    lines++;                            //analyzing the total member count to be registered
                }
                reader.close();
            } catch (Exception e) {        //exception handling
                e.printStackTrace();
            }

            if (lines >= 100) {             // validating the maximum member count
                System.out.println("Sorry maximum member count is 100");
            } else {
                remMemberCount = 100 - lines;       //give a message about the amount of members can be registered through the system
                if (mtype == 1) {
                    System.out.println(remMemberCount + " Members are Remaining to add to the system");
                    System.out.println("\nAdd a DEFAULT MEMBER");

                    try {
                        addDefaultInputs();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        String memberType = "Default Member";
                        System.out.println("Do you want to save this member (Y/N)?");
                        String saveStatus = in.next();
                        if (saveStatus.equals("Y") || saveStatus.equals("y")) {     //Member Saving process
                            try {                                                   //passing parameters through the constructor
                                DefaultMember newMember = new DefaultMember(membershipNo, memberName,memberGender, memberWeight,
                                        memberType,memberCity,memberContactNo, memberStartDate);
                                memberList.add(newMember);                  //ading all the values to the arrayList
                                SaveMember.saveDefaultMember(newMember);
                                System.out.println("DEFAULT MEMBER Successfully saved! ");      //writing to the file
                                memberList.clear();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                }
                if (mtype == 2) {               //adding a Student member
                    System.out.println(remMemberCount + " Members are Remaining to add to the system");
                    System.out.println("\nAdd a STUDENT MEMBER");

                    try {
                        addDefaultInputs();     //validation and exception handling
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("School Name: ");
                    String school = InputValidate.stringValidation(in);
                    String memberType = "Student Member";
                    System.out.print("School Grade: ");         //getting user inputs from the user
                    String memberGrade = in.next();
                    System.out.print("Parent Name: ");
                    String memberParentName = InputValidate.stringValidation(in);

                    System.out.println("Do you want to save this member (Y/N)?");
                    String saveStatus = in.next();                              //Student member saving process
                    if (saveStatus.equals("Y") || saveStatus.equals("y")) {
                        try {
                            StudentMember studentMember = new StudentMember(membershipNo, memberName,memberGender, memberStartDate,
                                    memberWeight, memberType,memberCity,memberContactNo, school,memberGrade,memberParentName);
                            memberList.add(studentMember);
                            SaveMember.SaveStudent(memberList);                   //adding to a arraylist and passing to the saveMember
                            System.out.println("Student member Successfully saved! ");
                            memberList.clear();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
                if (mtype == 3) {               //adding a Over 60 member
                    System.out.println(remMemberCount + " Members are Remaining to add to the system");
                    System.out.println("Add an OVER 60 MEMBER");

                    try {
                        addDefaultInputs();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Member Age: ");
                    int memberAge = in.nextInt();               //getting user information from the user
                    String memberType = "Over 60 Member";
                    System.out.print("has any medical Disability? (yes/no): ");
                    String memberDisability = InputValidate.stringValidation(in);

                    System.out.println("Do you want to save this member (Y/N)?");     //member saving process
                    String saveStatus = in.next();
                    if (saveStatus.equals("Y") || saveStatus.equals("y")) {
                        try {
                            Over60Member over60Member = new Over60Member(membershipNo, memberName,memberGender, memberWeight,
                                    memberType,memberCity,memberContactNo, memberStartDate, memberAge,memberDisability);
                            memberList.add(over60Member);
                            SaveMember.SaveOver60member(memberList);
                            System.out.println("OVer 60 member Successfully saved! ");
                            memberList.clear();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Please enter a number 1 or 2 or 3");
            addMember();
        }
    }

    @Override
    public void deleteMember(String id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
        ArrayList ardata = new ArrayList();
                                                        //method for Member Deletion
        while (reader.ready()) {
            String ln = reader.readLine();
            String[] lnData = ln.split(",");
            if (!lnData[0].equals(id)) {            //reading the file and getting the ID
                ardata.add(ln);
            }
        }

        File file = new File(SaveMember.fileDir);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < ardata.size(); i++) {
            bw.write(ardata.get(i).toString());
            if (i < ardata.size() - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    private void deleteMember() throws IOException {    //member Deletion and displaying information
        int lines = 0;

        try {
            System.out.print("Enter Member ID: ");
            myGymManager.deleteMember(in.next());       //deletion from the DeleteMember method
            System.out.println("Member is Deleted!");

            BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
            while (reader.readLine() != null) {
                lines++;
            }                                 //read the file and getting remaining slots to add to the system
            reader.close();
            remMemberCount = 100 - lines;

            System.out.println((remMemberCount) + " Members are Remaining to add to the system");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override                                          // Member printing as a table in console
    public void printMembers() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%3s%25s%25s%22s", "NUM", "NAME", "MEMBER TYPE", "ST.DATE");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------");
        while (reader.ready()) {                   //read the file and read each line
            String ln = reader.readLine();          //get the values to a String array and get data using index
            String[] lnData = ln.split(",");
            System.out.format("%2s%24s%24s%21s", lnData[0], lnData[1], lnData[3], lnData[4]);
            System.out.println("");

        }
    }

    @Override
    public void sortList() throws IOException {     //sorting the member list by Ascending order

        ArrayList<String> names = new ArrayList<>();
        String[] lnData;
        ArrayList<String[]> records = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%3s%25s%25s%22s", "NUM", "NAME", "MEMBER TYPE", "ST.DATE");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------");
        while (reader.ready()) {
            String ln = reader.readLine();     //reading each line of file and getting to a arraylist
            lnData = ln.split(",");
            records.add(lnData);
            names.add(lnData[1]);             //get the Member Name to an arrayList
        }

        Collections.sort(names);    //sorting by name

        for (String name : names) {
            for (String[] record : records) {       //printing the correspoding values after sorting
                if (name == record[1]) {
                    System.out.format("%3s%25s%25s%25s", record[0], record[1], record[3], record[4]);
                    System.out.println("");
                }
            }
        }
        System.out.println("Sorted the list!");
    }

    @Override
    public void launchGUI() {                       //launch GUI
        Application.launch(GymManagementGui.class);

    }

    public static void main(String[] args) throws IOException {     //Main Method
        myGymManager = new MyGymManager();
        myGymManager.mainDisplayMenu();
    }

    public List<DefaultMember> displayMember() {    //method to get the member ArrayList to the GUI
        return memberList;
    }
}
