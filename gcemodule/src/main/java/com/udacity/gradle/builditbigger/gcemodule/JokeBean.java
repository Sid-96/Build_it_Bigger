package com.udacity.gradle.builditbigger.gcemodule;

import com.example.JokeBox;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    public String getJoke() {
        return JokeBox.getRandomJoke();
    }
}