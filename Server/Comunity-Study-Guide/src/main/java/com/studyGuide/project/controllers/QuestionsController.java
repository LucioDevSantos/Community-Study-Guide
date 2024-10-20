package com.studyGuide.project.controllers;


import com.studyGuide.project.entitys.Alternative;
import com.studyGuide.project.entitys.OpenQuestion;
import com.studyGuide.project.entitys.Question;
import com.studyGuide.project.repositories.CommunityRepo;
import com.studyGuide.project.repositories.OpenQuestionRepo;
import com.studyGuide.project.repositories.QuestionRepo;
import com.studyGuide.project.services.CommunityService;
import com.studyGuide.project.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guide")
public class QuestionsController {

    // Repositories
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private CommunityRepo communityRepo;


    // Services
    @Autowired
    private QuestionService questionServices;
    @Autowired
    private CommunityService communityService;




    @PostMapping("/question/{id}")
    public ResponseEntity<Object> createQuestion(@RequestBody Question question, @PathVariable Long id){



            var questionModel = new Question(question.getContent());



            List<Alternative> options = new ArrayList<>();

            // coleta os dados de cada alternativa
            for (Alternative option : question.getOptionsList()) {

                Alternative optionModel = new Alternative(option.getName(), option.getContent(), option.getIsRight());
                optionModel.setQuestion(questionModel);
                options.add(optionModel);

            }

            // registra elas na entidade QUESTIONS
            questionModel.setOptionsList(options);

            // Registra a community em que a QUESTION foi criada
            questionModel.setCommunity(communityRepo.findById(id).orElseThrow(()-> new RuntimeException("not found")));

            // registra a QUESTION na community
        communityService.addQuestionCommunityService(questionModel.getCommunity().getId(), questionModel);

        // Salva a entidade no database
            Question questionSave = questionRepo.save(questionModel);



            return ResponseEntity.status(HttpStatus.valueOf(201)).body(questionSave);

    }

    @PostMapping("/question/open/{id}")
    public ResponseEntity<OpenQuestion> createOpen(@RequestBody OpenQuestion openQuestion, @PathVariable  Long id){


        openQuestion.setCommunity(communityRepo.findById(id).orElseThrow(()-> new RuntimeException("not found")));

        OpenQuestion open = questionServices.SaveOpenService(openQuestion);
        communityService.addOpenQuestionCommunity(open.getCommunity().getId(), open);


        return ResponseEntity.status(HttpStatus.valueOf(201)).body(open);
    }


    @PostMapping("/answer/{id}")
    public OpenQuestion RegisterAnswer(@RequestBody String answer, @PathVariable Long id){

        OpenQuestion openQuestion = questionServices.AddAnswer(id, answer);



        return openQuestion;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions(){


    return ResponseEntity.status(HttpStatus.OK).body(questionRepo.findAll());
    }


}
