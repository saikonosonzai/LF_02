package dataAccessObject;

import businessObjects.Vertragspartner;
import businessObjects.Ware;

import java.sql.*;
import java.util.ArrayList;

public class WareDAO {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:Kaufvertrag/src/data/Kaufvertrag.db";
    Connection connection = null;

    public WareDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Ware read(int warenNr) {
        Ware ware = null;
         connection = null;
        PreparedStatement preparedStatement = null;

        // Verbindung zur DB herstellen
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen
            String sql = "SELECT * FROM ware WHERE warenNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, warenNr);

            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();

            //Zeiger auf den ersten Datensatz setzen
            resultSet.next();

            //ResultSet auswerten
            ware = createObject(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ware;
    }

    public void delete(String warenNr) throws SQLException {
         connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM ware WHERE warenNr = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, warenNr);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    public void insert(Ware ware) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO ware(bezeichnung, beschreibung, preis, besonderheiten, maengel) VALUES(?,?,?,?,?)";

            String besonderheitenListe = "";
            for (String s: ware.getBesonderheitenListe()) {
                besonderheitenListe += s + "; ";
            }
            String maengelListe = "";
            for (String s: ware.getBesonderheitenListe()) {
                maengelListe += s +"; ";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ware.getBezeichnung());
            preparedStatement.setString(2, ware.getBeschreibung());
            preparedStatement.setDouble(3, ware.getPreis());
            preparedStatement.setString(4, besonderheitenListe);
            preparedStatement.setString(5, maengelListe);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            ware.setWarenNr(resultSet.getInt("Last_insert_rowid()"));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

    public Ware createObject(ResultSet resultSet) throws SQLException {
        String bezeichnung = resultSet.getString("bezeichnung");
        String beschreibung = resultSet.getString("beschreibung");
        double preis = resultSet.getDouble("preis");
        String besonderheiten = resultSet.getString("besonderheiten");
        String maengel = resultSet.getString("maengel");

        Ware ware = new Ware(bezeichnung, preis);
        ware.setBeschreibung(beschreibung);

        if (maengel != null) {
            String[] maengelListe = maengel.split(";");

            for (String s : maengelListe) {
                ware.getMaengelListe().add(s.trim());

            }
        }

        if (besonderheiten != null) {
            String[] besonderheitenListe = besonderheiten.split(";");

            for (String s : besonderheitenListe) {
                ware.getBesonderheitenListe().add(s.trim());
            }
        }
        return ware;
    }
}