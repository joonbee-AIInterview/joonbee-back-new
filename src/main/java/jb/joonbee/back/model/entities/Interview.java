package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "intervew")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class Interview extends AuditEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("카테고리 이름")
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Comment("gpt의 면접 평가")
    @Column(name = "gpt_opinion", nullable = true)
    private String gptOpinion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "interview"
    )
    private List<InterviewAndQuestion> interviewAndQuestionList = new ArrayList<>();
}
