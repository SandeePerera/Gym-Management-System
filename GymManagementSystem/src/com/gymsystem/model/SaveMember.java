package com.gymsystem.model;

import com.gymsystem.manager.MyGymManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveMember {       //This class includes the methods for writing the Gym members data to a FILE and saving

    public static String fileDir = "D:\\GymManagementSystem\\GymManagementSystem\\members.txt";

    public static void saveDefaultMember(DefaultMember defaultMember) throws Exception {    //method for saving a Default Member

        BufferedReader reader = new BufferedReader(new FileReader(fileDir));    //initialized a buffered Reader to read from the file

        ArrayList memberListData = new ArrayList();
        while (reader.ready()) {
            String data = reader.readLine();
            memberListData.add(data);   
        }

        ArrayList<DefaultMember> memberRow = MyGymManager.getMemberList();  //get the total memberList and store in another arrayList to save

        File file = new File(fileDir);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < memberListData.size(); i++) {
            bufferedWriter.write(memberListData.get(i).toString());
            bufferedWriter.newLine();
        }

        // file writing process Writing each data to the file from array Index and calling each get methods

        bufferedWriter.write(memberRow.get(0).getMembership_number() + "," + memberRow.get(0).getMember_name() +
                "," + memberRow.get(0).getMemberWeight() + "," + memberRow.get(0).getMemberType() +
                "," + memberRow.get(0).getMembership_start_date() + "," + memberRow.get(0).getMemberGender() +
                "," + memberRow.get(0).getMemberCity() + "," + memberRow.get(0).getMemberContactNo());

        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public static void SaveStudent(ArrayList<DefaultMember> studentMember) throws Exception {   //method for saving a Student Member

        BufferedReader reader = new BufferedReader(new FileReader(fileDir));

        ArrayList memberListData = new ArrayList();
        while (reader.ready()) {
            String data = reader.readLine();
            memberListData.add(data);
        }

        ArrayList<DefaultMember> memberRow = MyGymManager.getMemberList();

        File file = new File(fileDir);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < memberListData.size(); i++) {
            bufferedWriter.write(memberListData.get(i).toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.write(memberRow.get(0).getMembership_number() + "," + memberRow.get(0).getMember_name() +
                "," + memberRow.get(0).getMemberWeight() + "," + memberRow.get(0).getMemberType() +
                "," + memberRow.get(0).getMembership_start_date() + "," + memberRow.get(0).getMemberGender() +
                "," + memberRow.get(0).getMemberCity() + "," + memberRow.get(0).getMemberContactNo() +
                "," + ((StudentMember) memberRow.get(0)).getSchoolName() + "," + ((StudentMember) memberRow.get(0)).getMemberGrade() +
                "," + ((StudentMember) memberRow.get(0)).getMemberParentName());

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void SaveOver60member(ArrayList<DefaultMember> over60Member) throws Exception {   //method for saving a Over60 Member

        BufferedReader reader = new BufferedReader(new FileReader(fileDir));

        ArrayList memberListData = new ArrayList();
        while (reader.ready()) {
            String data = reader.readLine();
            memberListData.add(data);
        }

        ArrayList<DefaultMember> memberRow = MyGymManager.getMemberList();

        File file = new File(fileDir);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < memberListData.size(); i++) {
            bufferedWriter.write(memberListData.get(i).toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.write(memberRow.get(0).getMembership_number() + "," + memberRow.get(0).getMember_name() +
                "," + memberRow.get(0).getMemberWeight() + "," + memberRow.get(0).getMemberType() +
                "," + memberRow.get(0).getMembership_start_date() + "," + memberRow.get(0).getMemberGender() +
                "," + memberRow.get(0).getMemberCity() + "," + memberRow.get(0).getMemberContactNo() +
                "," + ((Over60Member) memberRow.get(0)).getAge() + "," + ((Over60Member)memberRow.get(0)).getMemberDisability());
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
