package com.studyGuide.project.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

// Dar TRUNCATE no database

@Entity
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<String> topics;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Alternative> optionsList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "community_id")
    @JsonIgnore
    private Community community;

        public Question(){  }

    public Question(String content){
        this.content = content;


    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topic) {
        this.topics = topics;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Alternative> getOptionsList(){
        return optionsList;
    }
    public void setOptionsList(List<Alternative> optionsList){
        this.optionsList = optionsList;
    }

}
