package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import jb.joonbee.back.model.base.CartId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "cart")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class Cart extends AuditEntity {

    @EmbeddedId
    private CartId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    @MapsId("memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    @MapsId("questionId")
    private Question question;
}
