package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import jb.joonbee.back.model.base.LikeId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "like")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class Like extends AuditEntity {

    @EmbeddedId
    private LikeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @MapsId("memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id", nullable = false)
    @MapsId("interviewId")
    private Interview interview;
}
