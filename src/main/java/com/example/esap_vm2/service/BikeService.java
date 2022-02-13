package com.example.esap_vm2.service;


import com.example.esap_vm2.model.Drive;
import com.example.esap_vm2.model.Bike;
import com.example.esap_vm2.repository.BikeRepository;
import com.example.esap_vm2.repository.DriveRepository;
import com.example.esap_vm2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private DriveRepository driveRepository;

    public void create(Bike bike){
        bikeRepository.save(bike);
    }

    public Bike get(Long id){ return bikeRepository.findById(id).get();}

    public List<Bike> getAll(){
        return bikeRepository.findAll().stream().sorted(Comparator.comparing(Bike::getBikeName)).collect(Collectors.toList());
    }

    public void update(Long bikeId, Bike newBikeData){
        Bike bike = bikeRepository.findById(bikeId).get();
        bike.setBikeName(newBikeData.getBikeName());
        bike.setPrice(newBikeData.getPrice());
        bikeRepository.save(bike);
    }

    public void delete(Long id){
        // fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true. doesn't work((
//        Bike bike = bikeRepository.findById(id).get();
//        for( Drive drive : bike.getDrives()){
//            driveRepository.deleteById(drive.getId());
//            bike.getDrives().remove(drive);
//        }
////        student.getGroup().getStudents().remove(student);
        bikeRepository.deleteById(id);
    }

    public List<Drive> getDrives(Long id){
        Bike Bike = bikeRepository.findById(id).get();
        return Bike.getDrives().stream().collect(Collectors.toList());
    }
}

