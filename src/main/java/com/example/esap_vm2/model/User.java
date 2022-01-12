package com.example.esap_vm2.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
//    @Column(name="user_id") // Exception in query: Select bike_bike_id from drives;
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private Integer budget;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true) // , orphanRemoval = true
    private Set<Drive> drives = new HashSet<>();

    public User() {
    }

    public User(String name, Integer budget) {
        this.name = name;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
    }

    public Set<Drive> getDrives() {
        return drives;
    }

    public void setDrives(Set<Drive> drives) {
        this.drives = drives;
    }
}
