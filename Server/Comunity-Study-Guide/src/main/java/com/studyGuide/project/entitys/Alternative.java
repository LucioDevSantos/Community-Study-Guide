package com.studyGuide.project.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alternatives")
public class Alternative implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String content;
    private boolean isRight;

    // DTO substituição
    @ManyToOne
    @JsonIgnore
        private Question question;


    public Alternative(){   }

    public Alternative(String name, String content, boolean isRight ) {
        this.name = name;
        this.content = content;
        this.isRight = isRight;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRight(boolean isRight){
        this.isRight = isRight;
    }

    public boolean getIsRight(){
        return isRight;
    }

    public Question getQuestion() {

        return question;
    }

    public String getQuestions(){
        return question.getContent() + question.getTopics();
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
