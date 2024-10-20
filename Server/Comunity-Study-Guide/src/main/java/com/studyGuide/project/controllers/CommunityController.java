package com.studyGuide.project.controllers;

import com.studyGuide.project.entitys.Community;
import com.studyGuide.project.repositories.CommunityRepo;
import com.studyGuide.project.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/community")
public class CommunityController {

    // Repositories
    @Autowired
    public CommunityRepo communityRepo;

    // Services
    @Autowired
    public CommunityService communityService;


    // criar comunidade, precisa-se apenas do name por enquanto...
    @PostMapping("/create")
    public ResponseEntity<Community> createCommunity(@RequestBody Community communityModel ){

        Community targetCommunity = new Community(communityModel.getName());

        targetCommunity.setCode(communityService.GenerateCommunityCode());

        var savedCommunity = communityRepo.save(targetCommunity);


        return ResponseEntity.status(HttpStatus.valueOf(201)).body(savedCommunity);


    }

    // Retorna todas as comunidades criadas
    @GetMapping("/")
    public ResponseEntity<List<Community>> getAllCommunities(){
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(communityRepo.findAll());
    }

    // Retorna apenas uma comunidade && retorna NULL quando não existe
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Community>> findCommunity(@PathVariable("id") Long id){
        Optional<Community> response = communityRepo.findById(id);

        return ResponseEntity.status(HttpStatus.valueOf(200)).body(response);

    }


}
