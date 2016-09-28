package com.udacity.gradle.builditbigger.gcemodule;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;


@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "gcemodule.builditbigger.gradle.udacity.com",
    ownerName = "gcemodule.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)

public class JokeEndpoint {

    @ApiMethod(name = "sendJoke")
    public JokeBean sendJoke(JokeBean jokeBean) {
        return jokeBean;
    }

}
