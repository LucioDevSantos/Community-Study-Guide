package com.studyGuide.project.services;

import com.studyGuide.project.entitys.Community;
import com.studyGuide.project.entitys.OpenQuestion;
import com.studyGuide.project.entitys.Question;
import com.studyGuide.project.repositories.CommunityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CommunityService {

    // Repositories
    @Autowired
    public CommunityRepo communityRepo;

    public int GenerateCommunityCode(){
        Random generator = new Random();

        return 1000 + generator.nextInt(9000);

    }



    public void addQuestionCommunityService(Long id, Question question) {

        Community targetCommunity = communityRepo.findById(id).orElseThrow(() -> new RuntimeException("no Community found :/"));

        targetCommunity.getQuestions().add(question);


    }

    public void addOpenQuestionCommunity(Long id, OpenQuestion question){
        Community targetCommunity = communityRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));

        targetCommunity.getOpenQuestions().add(question);
    }

}
