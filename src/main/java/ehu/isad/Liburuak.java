package ehu.isad;

import ehu.isad.controller.ui.LiburuKud;
import ehu.isad.controller.ui.XehetasunakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ehu.isad.Book;

import java.io.IOException;

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


    FXMLLoader loaderXehetasunak = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
    xehetasunakUI = (Parent) loaderXehetasunak.load();
    sceneXe = new Scene(xehetasunakUI);
    xehetasunakKud = loaderXehetasunak.getController();
    xehetasunakKud.setMainApp(this);

    FXMLLoader loaderLiburua = new FXMLLoader(getClass().getResource("/Liburua.fxml"));
    liburuUI = (Parent) loaderLiburua.load();
    sceneLib = new Scene(liburuUI,450,450);
    liburuKud = loaderLiburua.getController();
    liburuKud.setMainApp(this);

  }


  public static void main(String[] args) {
    launch(args);
  }

  public void xehetasunakErakutsi(String pIzenburua, String pArgitaletxea, String pOrri, Image pIrudia) {
    xehetasunakKud.setLabelIzenburu(pIzenburua);
    xehetasunakKud.setIrudi(pIrudia);
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
