package com.studyGuide.project.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Entity
public class Community implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "community")
    @JsonIgnore
    @Nullable
    private List<Question> Questions;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "community")
    @JsonIgnore
    @Nullable
    private List<OpenQuestion> OpenQuestions;


    public Community() { }

    public Community(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> questions) {
        Questions = questions;
    }

    public List<OpenQuestion> getOpenQuestions() {
        return OpenQuestions;
    }

    public void setOpenQuestions(List<OpenQuestion> openQuestions) {
        OpenQuestions = openQuestions;
    }

    
}
