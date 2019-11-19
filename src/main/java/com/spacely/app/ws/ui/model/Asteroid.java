package com.spacely.app.ws.ui.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Asteroid {

    @Id
    private String rockId;
    private String name;
    private Date discoveryDate = new Date();
    private Map<String, String> metadata = new HashMap<>();

    public String getRockId() {
        return rockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public void setRockId(String rockId) {
        this.rockId = rockId;
    }
}