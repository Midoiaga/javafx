package ehu.isad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Student extends Application {

    private Parent studentUI;
    private Stage stage;

    private StudentsController studentController;
    private Scene sceneSt;


    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary APIa aztertzen");
        stage.setScene(sceneSt);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderLiburua = new FXMLLoader(getClass().getResource("/tableview.fxml"));
        studentUI = (Parent) loaderLiburua.load();
        sceneSt = new Scene(studentUI);
        studentController = loaderLiburua.getController();
        studentController.setMainApp(this);

    }


    public static void main(String[] args) {
        launch(args);
    }
}

