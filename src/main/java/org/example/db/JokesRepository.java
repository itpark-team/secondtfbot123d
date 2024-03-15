package org.example.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JokesRepository {
    private Connection connection = null;

    public JokesRepository() {
        connection = DbConnector.getInstance().getConnection();
    }

    public ArrayList<Joke> getAllJokes() {
        ArrayList<Joke> jokes = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String selectQuery = String.format("SELECT * FROM jokes ORDER BY id ASC");

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String jokeText = resultSet.getString("joke_text");
                int rating = resultSet.getInt("rating");

                jokes.add(new Joke(id, jokeText, rating));
            }

            resultSet.close();

            statement.close();
        } catch (Exception e) {
            System.out.println("Ошибка запроса к базе данных");
        }

        return jokes;
    }

}
