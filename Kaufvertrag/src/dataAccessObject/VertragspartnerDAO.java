package dataAccessObject;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;

import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:Kaufvertrag/src/data/Kaufvertrag.db";

    public VertragspartnerDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    /**
     * Liest einen Vertragspartner auf Basis seiner Ausweisnummer
     *
     * @param ausweisNr Die Ausweisnummer
     * @return Der gewünschte Vertragspartner
     */
    Connection connection = null;
    public Vertragspartner read(String ausweisNr) {
        Vertragspartner vertragspartner = null;
        connection = null;
        PreparedStatement preparedStatement = null;

        // Verbindung zur DB herstellen
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen
            String sql = "SELECT * FROM vertragspartner WHERE ausweisNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);

            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();

            //Zeiger auf den ersten Datensatz setzen
            resultSet.next();

            //ResultSet auswerten
            vertragspartner = createObject(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vertragspartner;
    }

    public ArrayList<Vertragspartner> read() {
        connection = null;
        PreparedStatement preparedStatement;

        // Verbindung zur DB herstellen
        ArrayList<Vertragspartner> vertragspartnerListe = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen
            String sql = "SELECT * FROM vertragspartner";
            preparedStatement = connection.prepareStatement(sql);


            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();

            //Zeiger auf den ersten Datensatz setzen
            while (resultSet.next()) {

                //ResultSet auswerten

                vertragspartnerListe.add(createObject(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vertragspartnerListe;
    }

    public Vertragspartner createObject(ResultSet resultSet) throws SQLException {
        String nr = resultSet.getString("ausweisNr");
        String vorname = resultSet.getString("vorname");
        String nachname = resultSet.getString("nachname");
        String strasse = resultSet.getString("strasse");
        String hausNr = resultSet.getString("hausNr");
        String plz = resultSet.getString("plz");
        String ort = resultSet.getString("ort");

        Vertragspartner vertragspartner = new Vertragspartner(vorname, nachname);
        vertragspartner.setAusweisNr(nr);
        vertragspartner.setAdresse(new Adresse(strasse, hausNr, plz, ort));
        return vertragspartner;
    }


    public void delete(String nr) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM vertragspartner WHERE ausweisNr = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nr);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }


    public void insert(Vertragspartner vertragspartner) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO vertragspartner VALUES(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vertragspartner.getAusweisNr());
            preparedStatement.setString(2, vertragspartner.getVorname());
            preparedStatement.setString(3, vertragspartner.getNachname());
            preparedStatement.setString(4, vertragspartner.getAdresse().getStrasse());
            preparedStatement.setString(5, vertragspartner.getAdresse().getHausNr());
            preparedStatement.setString(6, vertragspartner.getAdresse().getPlz());
            preparedStatement.setString(7, vertragspartner.getAdresse().getOrt());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    public void update(String ausweisNr, Vertragspartner vertragspartner) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "UPDATE vertragspartner SET ausweisNr = ?, vorname = ?, nachname = ?, strasse = ?, hausNr = ?, plz = ?, ort = ? WHERE ausweisNr = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vertragspartner.getAusweisNr());
            preparedStatement.setString(2, vertragspartner.getVorname());
            preparedStatement.setString(3, vertragspartner.getNachname());
            preparedStatement.setString(4, vertragspartner.getAdresse().getStrasse());
            preparedStatement.setString(5, vertragspartner.getAdresse().getHausNr());
            preparedStatement.setString(6, vertragspartner.getAdresse().getPlz());
            preparedStatement.setString(7, vertragspartner.getAdresse().getOrt());
            preparedStatement.setString(8, ausweisNr);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}