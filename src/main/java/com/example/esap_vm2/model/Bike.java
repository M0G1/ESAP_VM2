package com.example.esap_vm2.model;

import javax.persistence.*;
import com.example.esap_vm2.model.Drive;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bikes")
public class Bike {
    @Id
//    @Column(name="bike_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "bike_id_seq", allocationSize = 1)
    private Long id;
    
    @Column(name="bike_name")
    private String bikeName;

    @Column(name="cost_per_hour")
    private Integer price; // cost_per_hours

    // drives
    @OneToMany(mappedBy = "bike", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // , orphanRemoval = true,
    private Set<Drive> drives = new HashSet<>();

    public Bike() {
    }

    public Bike(String bikeName, Integer price) {
        this.bikeName = bikeName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String name) {
        this.bikeName = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer cost) {
        this.price = cost;
    }

    public Set<Drive> getDrives() {
        return drives;
    }

    public void setDrives(Set<Drive> drives) {
        this.drives = drives;
    }
}
