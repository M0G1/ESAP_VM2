package com.example.esap_vm2.repository;

import com.example.esap_vm2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}