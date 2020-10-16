package ehu.isad;

import com.google.gson.Gson;
import ehu.isad.controller.LiburuKud;
import ehu.isad.controller.XehetasunakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Liburuak extends Application {

  private Parent liburuUI;
  private Parent xehetasunakUI;

  private Stage stage;

  private LiburuKud liburuKud;
  private XehetasunakKud xehetasunakKud;
  private Scene sceneLib;
  private Scene sceneXe;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("OpenLibrary APIa aztertzen");
    stage.setScene(sceneLib);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
    liburuUI = (Parent) loaderKautotu.load();
    sceneLib = new Scene(liburuUI,450,450);
    liburuKud = loaderKautotu.getController();
    liburuKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
    xehetasunakUI = (Parent) loaderMain.load();
    sceneXe = new Scene(xehetasunakUI);
    xehetasunakKud = loaderMain.getController();
    xehetasunakKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void xehetasunakErakutsi(String pIzenburua, String pArgitaletxea, String pOrri) {
    xehetasunakKud.setLabelIzenburu(pIzenburua);
    xehetasunakKud.setLabelArgitaletxe(pArgitaletxea);
    xehetasunakKud.setLabelOrri(pOrri);
    stage.setScene(sceneXe);
    stage.show();
  }
  public void liburuakErakutsi() {
    stage.setScene(sceneLib);
    stage.show();
  }
}
