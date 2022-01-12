package com.example.esap_vm2.service;

import com.example.esap_vm2.model.*;
import com.example.esap_vm2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriveService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private DriveRepository driveRepository;

    public void create(Drive drive, Long userId, Long bikeId) {
        User user = userRepository.getById(userId);
        Bike bike = bikeRepository.getById(bikeId);
        drive.setBike(bike);
        drive.setUser(user);
        driveRepository.save(drive);
    }

    public Drive get(Long id) {
        return driveRepository.getById(id);
    }

    public void delete(Long id) {
        Drive drive = driveRepository.getById(id);
        drive.getBike().getDrives().remove(drive);
        drive.getUser().getDrives().remove(drive);
        driveRepository.deleteById(id);
    }

    public List<Drive> getAll() {
        return driveRepository.findAll();
    }

}
