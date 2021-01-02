package com.gymsystem.Gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;
import com.gymsystem.manager.MyGymManager;
import com.gymsystem.model.DefaultMember;
import com.gymsystem.model.SaveMember;

public class GymManagementGui extends Application {     //Implementation of the GUI of gym management system
    private static MyGymManager gymManager;
    private TableView<DefaultMember> tableMember;
    private TextField filterMember;
    private ObservableList<DefaultMember> gymMembers = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gymManager = new MyGymManager();
        primaryStage.setTitle("Gym Management System - Life Light Fitness");
        primaryStage.setHeight(500);
        primaryStage.setWidth(976);

        TableColumn<DefaultMember, String> noColumn = new TableColumn<>("MembershipNo");
        noColumn.setMinWidth(99);
        noColumn.setCellValueFactory(new PropertyValueFactory<>("membership_number"));

        TableColumn<DefaultMember, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(121);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("member_name"));

        TableColumn<DefaultMember, String> typeColumn = new TableColumn<>("memberType");
        typeColumn.setMinWidth(125);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("memberType"));

        TableColumn<DefaultMember, String> dateColumn = new TableColumn<>("membershipDate");
        dateColumn.setMinWidth(130);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("membership_start_date"));

        TableColumn<DefaultMember, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setMinWidth(110);
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("memberGender"));

        TableColumn<DefaultMember, String> weightColumn = new TableColumn<>("Weight");
        weightColumn.setMinWidth(110);
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("memberWeight"));

        TableColumn<DefaultMember, String> contactColumn = new TableColumn<>("Contact No");
        contactColumn.setMinWidth(121);
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("memberContactNo"));

        TableColumn<DefaultMember, String> cityColumn = new TableColumn<>("City");
        cityColumn.setMinWidth(119);
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("memberCity"));


        filterMember = new TextField();
        filterMember.setPromptText("Enter name or ID");
        filterMember.setMinWidth(100);

        Label searchLabel = new Label("Search Member: ");
        searchLabel.setFont(new Font(17));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 11, 11, 60));
        hBox.setSpacing(11);
        hBox.getChildren().addAll(searchLabel, filterMember);


        tableMember = new TableView<>();
        tableMember.setItems(getGymMemberData());
        tableMember.getColumns().addAll(noColumn, nameColumn, typeColumn, dateColumn, genderColumn, weightColumn, contactColumn, cityColumn);


        VBox vBox = new VBox(5);
        Label label = new Label("Life Light Fitness - Member Management System");
        label.setFont(new Font(20));
        vBox.getChildren().addAll(label, tableMember, hBox);
        Scene scene = new Scene(vBox);
        tableMember.setEditable(true);

        vBox.setPadding(new Insets(17, 11, 15, 11));

        FilteredList<DefaultMember> filteredMemberList = new FilteredList<>(gymMembers, e -> true);
       filterMember.setOnKeyPressed(e -> {

            filterMember.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredMemberList.setPredicate((Predicate<? super DefaultMember>) gymMemberList -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String valueLowerCase = newValue.toLowerCase();

                    if (gymMemberList.getMember_name().toLowerCase().contains(valueLowerCase)) {
                        return true;
                    }
                    return false;
                });
            }));

            SortedList<DefaultMember> searchResults = new SortedList<>(filteredMemberList);
            searchResults.comparatorProperty().bind(tableMember.comparatorProperty());
            tableMember.setItems(searchResults);

        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ObservableList<DefaultMember> getGymMemberData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(SaveMember.fileDir));
        while (reader.ready()) {
            String data = reader.readLine();
            String[] memberList = data.split(",");
            gymMembers.addAll(new DefaultMember(memberList[0],memberList[1],memberList[5],memberList[2],memberList[3]
                                                ,memberList[6],memberList[7],memberList[4]));
            // 4= date , 5 =gender, 3= type

//            gymMembers.addAll((gymManager.displayMember()));


        }
        return gymMembers;

    }
}




