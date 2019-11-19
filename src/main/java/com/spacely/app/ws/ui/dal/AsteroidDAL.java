package com.spacely.app.ws.ui.dal;

import java.util.List;

import com.spacely.app.ws.ui.model.Asteroid;

public interface AsteroidDAL {

    List<Asteroid> getAllAsteroid();

    Asteroid getAsteroidById(String rockId);

    Asteroid addNewAsteroid(Asteroid name);

    Object getAllAsteroidMetadata(String userId);

    String getAsteroidMetadata(String rockId, String key);

    String addAsteroidMetadata(String rockId, String key, String value);
}