package dev.project.hibernateFilterImplementation.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Filter;

@Entity
@Table(name = "SpringTestTable")
@Filter(name = "countryFilter", condition = "country = :country")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
