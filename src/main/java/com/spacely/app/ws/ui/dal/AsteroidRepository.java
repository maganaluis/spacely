package com.spacely.app.ws.ui.dal;

import com.spacely.app.ws.ui.model.Asteroid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsteroidRepository extends MongoRepository<Asteroid, String> {

}