package jb.joonbee.back.model.base;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class InterviewAndQuestionId implements Serializable {
    private Long interviewId;
    private Long questionId;
}
