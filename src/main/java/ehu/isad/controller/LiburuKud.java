package ehu.isad.controller;

import com.google.gson.Gson;
import ehu.isad.Book;
import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
    Book liburua= this.readFromUrl(book.getIsbn());
    mainapp.xehetasunakErakutsi(liburua.getDetails().getTitle(),liburua.getDetails().getPublishers(),liburua.getDetails().getNumber_of_pages());
  }
  public void setMainApp(Liburuak mainapp){
    this.mainapp=mainapp;
  }
  private Book readFromUrl(String isbn) throws IOException {
    URL openlibrary = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:"+isbn+"&jscmd=details&format=json");
    URLConnection yc = openlibrary.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    String inputLine = in.readLine();
    in.close();

    String[] zatiak = inputLine.split("ISBN:"+isbn+"\":");
    inputLine = zatiak[1].substring(0, zatiak[1].length()-1);

    Gson gson = new Gson();
    return gson.fromJson(inputLine, Book.class);
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
    comboZerbitzua.getItems().addAll(
            new Book("1491910399", "R for Data Science"),
            new Book("1491946008", "Fluent Python"),
            new Book("9781491906187", "Data Algorithms"));
  }


}
