package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.androidlibrary.JokeViewActivity;
import com.udacity.gradle.builditbigger.gcemodule.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.gcemodule.jokeApi.model.JokeBean;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static JokeApi myApiService = null;
    private Context context;

    public JokesAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if (myApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-builditbigger-1322.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.sendJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeViewActivity.class);
        intent.putExtra(JokeViewActivity.JOKE_KEY, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
