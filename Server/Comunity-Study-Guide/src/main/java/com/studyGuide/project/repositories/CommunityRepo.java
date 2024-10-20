package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepo extends JpaRepository<Community, Long> {
}
