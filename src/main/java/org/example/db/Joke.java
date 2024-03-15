package org.example.db;

public class Joke {
    private int id;
    private String jokeText;
    private int rating;

    public Joke(int id, String jokeText, int rating) {
        this.id = id;
        this.jokeText = jokeText;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getJokeText() {
        return jokeText;
    }

    public int getRating() {
        return rating;
    }


}
