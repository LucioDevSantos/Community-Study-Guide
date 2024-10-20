package com.studyGuide.project.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "openQuestions")
public class OpenQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<String> topic;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @Nullable
    @Column(nullable = true)
    private List<String> Answers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "community_id")
    @JsonIgnore
    private Community community;


    public OpenQuestion() { }

    public OpenQuestion(List<String> topic, String content, @Nullable List<String> answers) {
        this.topic = topic;
        this.content = content;
        Answers = answers;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Nullable
    public List<String> getAnswers() {
        return Answers;
    }

    public void setAnswers(@Nullable List<String> answers) {
        Answers = answers;
    }
}
