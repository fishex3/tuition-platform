package com.example.tuition_platform.mapper;

import com.example.tuition_platform.domain.dto.TuteePostingRequest;
import com.example.tuition_platform.domain.dto.TuteePostingResponse;
import com.example.tuition_platform.domain.dto.TutorPostingResponse;
import com.example.tuition_platform.domain.entity.TuteePosting;
import com.example.tuition_platform.domain.entity.TutorPosting;
import org.springframework.stereotype.Service;

@Service
public class TuteeMapper {
   public TuteePostingResponse toDto(TuteePosting tuteePosting) {
       return new TuteePostingResponse(
               tuteePosting.getId(),
               tuteePosting.getPostedBy(),
               tuteePosting.getSubject(),
               tuteePosting.getContent(),
               tuteePosting.getEducationLevel(),
               tuteePosting.getRates(),
               tuteePosting.getLocation(),
               tuteePosting.getCreatedAt()
       );
   }
   public TuteePosting fromDto(TuteePostingRequest tuteePostingRequest) {
       return new TuteePosting(
               tuteePostingRequest.postedBy(),
               tuteePostingRequest.subject(),
               tuteePostingRequest.content(),
               tuteePostingRequest.educationLevel(),
               tuteePostingRequest.rates(),
               tuteePostingRequest.location()
       );
   }
}
