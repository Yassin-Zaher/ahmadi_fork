package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.model.Daret;
import com.codewitharjun.fullstackbackend.model.Participation;
import com.codewitharjun.fullstackbackend.model.ParticipationRequest;
import com.codewitharjun.fullstackbackend.model.UserEntity;
import com.codewitharjun.fullstackbackend.repository.DaretRepository;
import com.codewitharjun.fullstackbackend.repository.ParticipationRepository;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DaretRepository daretRepository;
    @Autowired
    private ParticipationRepository pariticipationRepository;

    @PostMapping("/participate")
    public void saveParticipation(@RequestBody ParticipationRequest part) {
        UserEntity userEntity = userRepository.findById(part.getIduser())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + part.getIduser()));
        Daret daret = daretRepository.findById(part.getIddaret())
                .orElseThrow(() -> new IllegalArgumentException("Daret not found with id: " + part.getIddaret()));

        Participation participation = new Participation();
        participation.setUserEntity(userEntity);
        participation.setDaret(daret);
        participation.setAmount(part.getAmount());
        pariticipationRepository.save(participation);
    }
}
