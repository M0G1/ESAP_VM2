package com.example.esap_vm2.model;

import javax.persistence.*;

@Entity
@Table(name = "drives")
public class Drive {
    @Id
//    @Column(name = "drive_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "drive_id_seq", allocationSize = 1)
    private Long id;

    private Integer hours;
    private Integer cost;

    @ManyToOne
    private User user;
    @ManyToOne
    private Bike bike;

    public Drive() {
    }

    public Long getId() {
        return id;
    }

    public Drive(Integer hours) {
        this.hours = hours;
    }

    public Drive(Integer hours, Integer cost) {
        this.hours = hours;
        this.cost = cost;
    }

    public Drive(Integer hours, User user, Bike bike) {
        this.hours = hours;
        this.user = user;
        this.bike = bike;
        this.cost = hours * bike.getPrice();
    }


    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
