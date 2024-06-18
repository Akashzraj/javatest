package javatest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CameraController {

    @FXML
    private ComboBox<String> areaCodeComboBox;
    @FXML
    private Label numOfStudentsLabel;
    @FXML
    private TableView<Student> studentTableView;

    private ObservableList<Student> students = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        loadStudentsFromDatabase();
        populateAreaCodeComboBox();
        updateNumOfStudentsLabel();
    }

    private void loadStudentsFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest", "Akash", "palamalayil");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("studentNumber"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("telephone"),
                        resultSet.getString("address"),
                        resultSet.getString("province"),
                        resultSet.getDouble("averageGrade"),
                        resultSet.getString("major")
                );
                students.add(student);
            }
            studentTableView.setItems(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateAreaCodeComboBox() {
        ObservableList<String> areaCodes = FXCollections.observableArrayList();
        for (Student student : students) {
            String areaCode = student.getTelephone().substring(0, 3);
            if (!areaCodes.contains(areaCode)) {
                areaCodes.add(areaCode);
            }
        }
        FXCollections.sort(areaCodes);
        areaCodes.add(0, "All"); // Add an "All" option at the beginning
        areaCodeComboBox.setItems(areaCodes);
    }

    private void updateNumOfStudentsLabel() {
        numOfStudentsLabel.setText("Number of Students: " + students.size());
    }

    @FXML
    private void applyFilter() {
        String selectedAreaCode = areaCodeComboBox.getSelectionModel().getSelectedItem();

        ObservableList<Student> filteredStudents = FXCollections.observableArrayList();

        // Filter based on selected area code
        if (selectedAreaCode != null && !selectedAreaCode.equals("All")) {
            for (Student student : students) {
                String areaCode = student.getTelephone().substring(0, 3);
                if (areaCode.equals(selectedAreaCode)) {
                    filteredStudents.add(student);
                }
            }
        } else {
            filteredStudents.addAll(students);
        }

        // Update TableView and number of students label
        studentTableView.setItems(filteredStudents);
        updateNumOfStudentsLabel();
    }
}
