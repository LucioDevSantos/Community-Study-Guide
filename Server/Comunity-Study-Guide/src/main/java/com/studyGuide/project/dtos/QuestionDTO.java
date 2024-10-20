package com.studyGuide.project.dtos;


import com.studyGuide.project.entitys.Alternative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public record QuestionDTO(@NotBlank @NotNull String topic, String content, ArrayList<Alternative> optionsList ) {



}
