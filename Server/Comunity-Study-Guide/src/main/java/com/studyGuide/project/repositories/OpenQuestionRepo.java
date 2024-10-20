package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.Alternative;
import com.studyGuide.project.entitys.OpenQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenQuestionRepo extends JpaRepository<OpenQuestion, Long> {




}
