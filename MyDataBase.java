import java.sql.*;

public class MyDataBase {
    public String pilote;
    public String url;
    public String nom_utilisateur;
    public String password;
    private Connection maConnection;
    private Statement stm ;
    private ResultSet res;
    MyDataBase(String pilote,String url,String nom_utilisateur,String password){
        this.pilote = pilote;
        this.url = url;
        this.nom_utilisateur = nom_utilisateur;
        this.password = password;
        try
        {
            Class.forName (pilote);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Driver loading error: " + e);
        }

        //2)Etape 2:	Etablir une connexion ==>
        try
        {
            maConnection = DriverManager.getConnection(this.url,this.nom_utilisateur,this.password);
        }
        catch(SQLException e)
        {
            System.err.println("Error opening SQL connection: " + e);
        }


        //3)Etape 3:	Cr�er un objet Statement ==>
        try
        {
            stm = maConnection.createStatement();
        }
        catch(SQLException e)
        {
            System.err.println("Error creating SQL statement: " + e);
        }
    }
    public int Ajouter(String nom, String genre)
    {
        try
        {
            int resUpd=stm.executeUpdate("INSERT INTO utilisateurs (nom, genre) VALUES ('"+nom+"','"+genre+"')");
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    public int Supprimer(int id)
    {
        try
        {
            int resUpd=stm.executeUpdate("DELETE FROM utilisateurs WHERE id="+id);
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    public int Modifier(int id, String nom, String genre)
    {
        try
        {
            int resUpd=stm.executeUpdate("UPDATE utilisateurs set nom='"+nom+"', genre='"+genre+"' WHERE id="+id);
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }



}
