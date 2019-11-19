package com.spacely.app.ws.ui.controller;

import java.util.List;

import com.spacely.app.ws.ui.dal.AsteroidDAL;
import com.spacely.app.ws.ui.dal.AsteroidRepository;
import com.spacely.app.ws.ui.model.Asteroid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("asteroids")
public class AsteroidController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final AsteroidRepository asteroidRepository;

    private final AsteroidDAL asteroidDAL;

    public AsteroidController(AsteroidRepository asteroidRepository, AsteroidDAL asteroidDAL) {
        this.asteroidRepository = asteroidRepository;
        this.asteroidDAL = asteroidDAL;
    }


    @PostMapping
    public Asteroid addNewUsers(@RequestBody Asteroid name) {
        LOG.info("Saving user.");
        return asteroidRepository.save(name);
    }

    @GetMapping
    public List<Asteroid> getAllAsteroids() {
        LOG.info("Getting all users.");
        return asteroidRepository.findAll();
    }
}
