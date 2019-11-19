package com.spacely.app.ws.ui.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spacely.app.ws.ui.model.Asteroid;

@Repository
public class AsteroidDALImpl implements AsteroidDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Asteroid> getAllAsteroid() {
        return mongoTemplate.findAll(Asteroid.class);
    }

    @Override
    public Asteroid getAsteroidById(String rockId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("rockId").is(rockId));
        return mongoTemplate.findOne(query, Asteroid.class);
    }

    @Override
    public Asteroid addNewAsteroid(Asteroid name) {
        mongoTemplate.save(name);
        // Now, user object will contain the ID as well
        return name;
    }

    @Override
    public Object getAllAsteroidMetadata(String rockId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("rockId").is(rockId));
        Asteroid rock = mongoTemplate.findOne(query, Asteroid.class);
        return rock != null ? rock.getMetadata() : "User not found.";
    }

    @Override
    public String getAsteroidMetadata(String rockId, String key) {
        Query query = new Query();
        query.fields().include("asteroidMetadata");
        query.addCriteria(Criteria.where("rockId").is(rockId).andOperator(Criteria.where("asteroidMetadata." + key).exists(true)));
        Asteroid user = mongoTemplate.findOne(query, Asteroid.class);
        return user != null ? user.getMetadata().get(key) : "Not found.";
    }

    @Override
    public String addAsteroidMetadata(String rockId, String key, String value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("rockId").is(rockId));
        Asteroid asteroid = mongoTemplate.findOne(query, Asteroid.class);
        if (asteroid != null) {
            asteroid.getMetadata().put(key, value);
            mongoTemplate.save(asteroid);
            return "Key added.";
        } else {
            return "Asteroid not found.";
        }
    }
}
