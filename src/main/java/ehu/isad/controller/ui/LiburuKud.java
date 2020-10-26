package ehu.isad.controller.ui;

import com.google.gson.Gson;
import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.controller.db.ZerbitzuKud;
import ehu.isad.utils.Sarea;
import ehu.isad.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.util.StringConverter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {
  private Liburuak mainapp;

  @FXML
  private ComboBox comboZerbitzua;
  @FXML
  private Button btnBilatu;


  @FXML
  void onBilatu(ActionEvent event) throws IOException{
    Book book = (Book)comboZerbitzua.getValue();
    Sarea sarea= new Sarea();
    ZerbitzuKud kud= ZerbitzuKud.getInstance();
    if(ZerbitzuKud.getInstance().tituluosoa(book.getIsbn())==null){
      Book liburua= sarea.readFromUrl(book.getIsbn());
      kud.informazioa(book.getIsbn(),liburua.getDetails().getTitle(),liburua.getDetails().getPublishers(),liburua.getDetails().getNumber_of_pages(),liburua.getThumbnail_url()+"/"+book.getTitle());
      mainapp.xehetasunakErakutsi(liburua.getDetails().getTitle(),liburua.getDetails().getPublishers(),liburua.getDetails().getNumber_of_pages(),sarea.createImage(liburua.getThumbnail_url()));
      sarea.download(liburua.getThumbnail_url(), book.getTitle());
    }
    else {
      String irudia= "file:///"+kud.irudia(book.getIsbn());
      Image irudi=sarea.createImage(irudia);
      mainapp.xehetasunakErakutsi(kud.tituluosoa(book.getIsbn()),kud.argitaletxea(book.getIsbn()),kud.orrikop(book.getIsbn()),irudi);

    }

  }
  public void setMainApp(Liburuak mainapp){
    this.mainapp=mainapp;
  }

  private void converter(){
    comboZerbitzua.setConverter(new StringConverter<Book>() {
      @Override
      public String toString(Book book) {
        if (book==null)
          return "";
        return book.getTitle();
      }

      @Override
      public Book fromString(String string) {
        return null;
      }
    });
  }
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.converter();
    List<Book> liburuList = ZerbitzuKud.getInstance().lortuZerbitzuak();
    ObservableList<Book> liburuak = FXCollections.observableArrayList(liburuList);

    comboZerbitzua.setItems( liburuak );

  }


}
