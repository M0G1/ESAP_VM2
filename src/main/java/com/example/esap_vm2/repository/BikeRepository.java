package com.example.esap_vm2.repository;

import com.example.esap_vm2.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}