package com.studyGuide.project.services;


import com.studyGuide.project.entitys.OpenQuestion;
import com.studyGuide.project.repositories.OpenQuestionRepo;
import com.studyGuide.project.repositories.QuestionRepo;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    // Repositories
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private OpenQuestionRepo OpenRepo;


    public OpenQuestion SaveOpenService(OpenQuestion openQuestion){
        var savedQuestion = OpenRepo.save(openQuestion);

        return savedQuestion;
    }


    public OpenQuestion AddAnswer(Long id, String answer){

        OpenQuestion open = OpenRepo.findById(id).orElseThrow(() -> new RuntimeException("no Question Found :/"));

        open.getAnswers().add(answer);

        return OpenRepo.save(open);


    }



}
