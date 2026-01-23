package com.company.platform.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sample_entity")
public class SampleEntity {

    @Id
    private String id;

    protected SampleEntity() {
    }

    public SampleEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
