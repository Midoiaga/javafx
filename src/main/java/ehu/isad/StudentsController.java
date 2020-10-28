package ehu.isad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;



    public class StudentsController implements Initializable {
        private Student mainapp;

        @FXML
        private TableView<StudentsModel> tbData;
        @FXML
        public TableColumn<StudentsModel, Integer> studentId;
        @FXML
        public TableColumn<StudentsModel, String> firstName;
        @FXML
        public TableColumn<StudentsModel, String> lastName;


        // add your data here from any source
        private ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
                new StudentsModel(1, "Jon", "Guridi"),
                new StudentsModel(2, "Ane", "Bengoa")
        );

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            // modeloaren datuak taulan txertatu
            tbData.setItems(studentsModels);
        }

    public void setMainApp(Student mainapp) {
        this.mainapp = mainapp;
    }
}