package ehu.isad.controller.db;

import ehu.isad.Book;
import ehu.isad.utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ZerbitzuKud {

    private static final ZerbitzuKud instance = new ZerbitzuKud();

    public static ZerbitzuKud getInstance() {
        return instance;
    }

    private ZerbitzuKud() {
    }

    public List<Book> lortuZerbitzuak() {

        String query = "select isbn, titulua from liburu";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        List<Book> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                String kodea = rs.getString("isbn");
                String izena = rs.getString("titulua");
                Book berria= new Book(kodea,izena);
                emaitza.add(berria);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }
    public String tituluosoa(String pIsbn){

        String query = "select tituluosoa from liburu where isbn='"+pIsbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String emaitza="";
        try {
            if(rs.next()){
                emaitza= rs.getString("tituluosoa");
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza ;
    }
    public String argitaletxea(String pIsbn){

        String query = "select argitaletxea from liburu where isbn='"+pIsbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String emaitza="";
        try {
            if(rs.next()){
                emaitza= rs.getString("argitaletxea");
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza ;
    }
    public String orrikop(String pIsbn){

        String query = "select orrikop from liburu where isbn='"+pIsbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String emaitza="";
        try {
            if(rs.next()){
                emaitza= rs.getString("orrikop");
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza ;
    }
    public String irudia (String pIsbn){

        String query = "select irudia from liburu where isbn='"+pIsbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String emaitza="";
        try {
            if(rs.next()){
                emaitza= rs.getString("irudia");
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza ;
    }
    public void informazioa(String pIsbn,String ptitulua, String pArgitaletxea, String pOrri, String pPath){
        String query = "update liburu set argitaletxea=\""+pArgitaletxea+"\" where isbn='"+pIsbn+"';";
        String query1= "update liburu set tituluosoa='"+ptitulua+"' where isbn='"+pIsbn+"';";
        String query2= "update liburu set orrikop='"+pOrri+"' where isbn='"+pIsbn+"';";
        String query3= "update liburu set irudia='"+pPath+"' where isbn='"+pIsbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
        dbKudeatzaile.execSQL(query1);
        dbKudeatzaile.execSQL(query2);
        dbKudeatzaile.execSQL(query3);

    }
}