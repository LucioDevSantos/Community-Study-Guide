package com.studyGuide.project.dtos;

import com.studyGuide.project.entitys.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlternativesDTO(@NotNull @NotBlank String alternative_content, boolean isRight, Question question) {


}
