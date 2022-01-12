package com.example.esap_vm2.service;

import com.example.esap_vm2.model.Drive;
import com.example.esap_vm2.model.User;
import com.example.esap_vm2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user){
        userRepository.save(user);
    }

    public User get(Long id){ return userRepository.getById(id);}

    public List<User> getAll(){
        return userRepository.findAll().stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
    }

    public void update(Long userId, User newUserData){
        User user = userRepository.findById(userId).get();
        user.setBudget(newUserData.getBudget());
        user.setName(newUserData.getName());
        userRepository.save(user);
    }

    public void delete(Long id){userRepository.deleteById(id);}

    public List<Drive> getDrives(Long id){
        User user = userRepository.getById(id);
        return user.getDrives().stream().collect(Collectors.toList());
    }
}
