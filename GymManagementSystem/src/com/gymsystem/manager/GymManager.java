package com.gymsystem.manager;

import java.io.IOException;

public interface GymManager {       //Interface for the class MyGymManager

    void addMember();               //all the methods are implemented in the MyGymManager

    void deleteMember(String id) throws IOException;

    void printMembers() throws IOException;

    void sortList() throws IOException;

    void launchGUI();

}
