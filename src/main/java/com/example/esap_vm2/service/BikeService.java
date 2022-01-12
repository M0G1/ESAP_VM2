package com.example.esap_vm2.service;


import com.example.esap_vm2.model.Drive;
import com.example.esap_vm2.model.Bike;
import com.example.esap_vm2.repository.BikeRepository;
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

    public void create(Bike bike){bikeRepository.save(bike);}

    public Bike get(Long id){ return bikeRepository.getById(id);}

    public List<Bike> getAll(){
        return bikeRepository.findAll().stream().sorted(Comparator.comparing(Bike::getBikeName)).collect(Collectors.toList());
    }

    public void update(Long bikeId, Bike newBikeData){
        Bike bike = bikeRepository.findById(bikeId).get();
        bike.setBikeName(newBikeData.getBikeName());
        bike.setPrice(newBikeData.getPrice());
        bikeRepository.save(bike);
    }

    public void delete(Long id){bikeRepository.deleteById(id);}

    public List<Drive> getDrives(Long id){
        Bike Bike = bikeRepository.getById(id);
        return Bike.getDrives().stream().collect(Collectors.toList());
    }
}

