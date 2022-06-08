package dao;

import businessObjects.Game;

import java.sql.*;

public class GameDao {

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:Games/src/data/Games.db";

    Connection connection = null;

    public GameDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Game read(int nr) throws SQLException {
        Game game = null;
        connection = null;
        PreparedStatement preparedStatement;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT * FROM Games WHERE nr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nr);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            game = new Game(resultSet.getString("bezeichnung"));
            String genre = resultSet.getString("genre");
            if (genre != null) {
                String[] genreListe = genre.split(";");

                for (String s : genreListe) {
                    game.getGenre().add(s.trim());

                }
            }

            game.setPreis(resultSet.getDouble("preis"));
            game.setEntwickler(resultSet.getString("entwickler"));
            game.setBewertung(resultSet.getDouble("bewertung"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return game;
    }

    public void delete(String nr) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM Games WHERE nr = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nr);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void insert(String bezeichnung, String genre, double preis, String entwickler, double bewertung) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO Games(bezeichnung, genre, preis, entwickler, bewertung) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bezeichnung);
            preparedStatement.setString(2, genre);
            preparedStatement.setDouble(3, preis);
            preparedStatement.setString(4, entwickler);
            preparedStatement.setDouble(5, bewertung);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void update(String bezeichnung, String genre, double preis, String entwickler, double bewertung, int nr) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "UPDATE Games SET bezeichnung = ?, genre = ?, preis = ?, entwickler = ?, bewertung = ? WHERE nr = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bezeichnung);
            preparedStatement.setString(2, genre);
            preparedStatement.setDouble(3, preis);
            preparedStatement.setString(4, entwickler);
            preparedStatement.setDouble(5, bewertung);
            preparedStatement.setInt(6,nr);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

}