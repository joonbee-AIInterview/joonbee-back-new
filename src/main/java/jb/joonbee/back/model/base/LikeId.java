package jb.joonbee.back.model.base;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
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
public class LikeId implements Serializable {
    private Long memberId;
    private Long interviewId;
}
