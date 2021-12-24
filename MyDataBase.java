import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MyDataBase {

    private final String pilote = "com.mysql.jdbc.Driver";
    private final String url ="jdbc:mysql://localhost/examen";
    private final String nom_utilisateur ="root";
    private final String password = "";
    private Connection maConnection;
    private Statement stm ;
    private ResultSet res;
    MyDataBase(){
        initDB();
    }

    private void initDB() {
        try
        {
            Class.forName (pilote);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Driver loading error: " + e);
        }

        try
        {
            maConnection = DriverManager.getConnection(this.url,this.nom_utilisateur,this.password);
        }
        catch(SQLException e)
        {
            System.err.println("Error opening SQL connection: " + e);
        }


        try
        {
            stm = maConnection.createStatement();
        }
        catch(SQLException e)
        {
            System.err.println("Error creating SQL statement: " + e);
        }
    }



    public int Ajouter(Personne personne)
    {
        try
        {

            int resUpd=stm.executeUpdate("INSERT INTO utilisateurs (nom, genre) VALUES ('"+personne.getNom()+"','"+personne.getGenre()+"')");
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }


    public void remplirTab(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            this.res = this.stm.executeQuery("select * from utilisateurs");
            Object[] ligne = new Object[model.getColumnCount()];

            while(this.res.next()) {
                for(int i = 0; i < ligne.length; ++i) {
                    ligne[i] = this.res.getString(i+1);
                }
                model.addRow(ligne);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }

    }


    public String getPersonnes()  {
        String result ="";
        try {
            this.res = this.stm.executeQuery("select count(*) from utilisateurs");
            while (this.res.next()) {
                result = this.res.getString(1);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public String getPersonneByGenre(String genre)  {
        String result ="";
        try {
            this.res = this.stm.executeQuery("select count(*) from utilisateurs where genre ='"+genre+"'");
            while (this.res.next()) {
                result = this.res.getString(1);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


}
