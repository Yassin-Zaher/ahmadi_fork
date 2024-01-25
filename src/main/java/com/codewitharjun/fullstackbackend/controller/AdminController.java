package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.exception.DaretNotFoundException;
import com.codewitharjun.fullstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fullstackbackend.model.Daret;
import com.codewitharjun.fullstackbackend.model.Participation;
import com.codewitharjun.fullstackbackend.model.UserEntity;
import com.codewitharjun.fullstackbackend.repository.DaretRepository;
import com.codewitharjun.fullstackbackend.repository.ParticipationRepository;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
@CrossOrigin("http://localhost:3000")

public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DaretRepository daretRepository;
    @Autowired
    private ParticipationRepository participationRepository;

    @GetMapping("/user/all")
    List<UserEntity> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    UserEntity updateUser(UserEntity newUserEntity, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUserEntity.getUsername());
                    user.setName(newUserEntity.getName());
                    user.setEmail(newUserEntity.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

    @PostMapping("/daret/save")
    public Daret newDaret(@RequestBody Daret newDaret) {
        return daretRepository.save(newDaret);
    }


    @GetMapping("/daret/all")
    List<Daret> getAlldarets() {
        return daretRepository.findAll();
    }


    @DeleteMapping("/daret/{id}")
    String deleteDaret(@PathVariable Long id){
        if(!daretRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        daretRepository.deleteById(id);
        return  "Daret with id "+id+" has been deleted success.";
    }

    @GetMapping("/daret/info/{id}")
    Optional<Daret> getDaretById(@PathVariable Long id) {
        return daretRepository.findById(id);
    }

    @PutMapping("/daret/edit/{id}")
    Daret updateDaret(Daret newDaret, @PathVariable Long id) {
        return daretRepository.findById(id)
                .map(daret -> {
                    daret.setName(newDaret.getName());
                    daret.setNumberOfParticipants(newDaret.getNumberOfParticipants());
                    daret.setAmountPerPeriod(newDaret.getAmountPerPeriod());
                    daret.setPeriodicity(newDaret.getPeriodicity());
                    return daretRepository.save(daret);
                }).orElseThrow(() -> new DaretNotFoundException(id));
    }

    @GetMapping("/darets_part/{id}")
    Collection<Participation> findparticipent(@PathVariable  Long id){
        return participationRepository.findById(id).stream().collect(Collectors.toSet());
    }




}

