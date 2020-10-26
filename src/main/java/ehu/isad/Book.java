package ehu.isad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Book {
    String isbn;
    String title;

    String info_url;
    String bib_key;
    String preview_url;
    String thumbnail_url;
    Details details;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public Details getDetails(){
        return this.details;
    }
    public String getThumbnail_url(){return this.thumbnail_url;}

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", info_url='" + info_url + '\'' +
                ", bib_key='" + bib_key + '\'' +
                ", preview_url='" + preview_url + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", details=" + details +
                '}';
    }
}

