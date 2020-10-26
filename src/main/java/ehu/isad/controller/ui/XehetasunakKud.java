package ehu.isad.controller.ui;

import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class XehetasunakKud {
  private Liburuak mainapp;
  @FXML
  private Label labelIzenburu;

  @FXML
  private Label labelArgitaletxe;

  @FXML
  private Label labelOrri;

  @FXML
  private Button btnAtzera;

  @FXML
  private ImageView imaIrudi;

  @FXML
  void onAtzera(ActionEvent event) {
    this.mainapp.liburuakErakutsi();
  }
  public void setIrudi(Image pIrudi){this.imaIrudi.setImage(pIrudi);}

  public void setMainApp(Liburuak mainapp) {
    this.mainapp = mainapp;
  }

  public void setLabelIzenburu(String pIzenburu) {
    this.labelIzenburu.setText(pIzenburu);
  }

  public void setLabelArgitaletxe(String pArgitaletxe) {
    this.labelArgitaletxe.setText(pArgitaletxe);
  }
  public void setLabelOrri(String pOrri){
    this.labelOrri.setText(pOrri);
  }
}