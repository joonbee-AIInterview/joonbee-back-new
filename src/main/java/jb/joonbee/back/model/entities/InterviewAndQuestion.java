package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import jb.joonbee.back.model.base.InterviewAndQuestionId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "interview_and_question")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class InterviewAndQuestion extends AuditEntity {

    @EmbeddedId
    private InterviewAndQuestionId id;

    @Comment("질문의 답변(사용자)")
    @Column(name = "answer_content")
    private String answerContent;

    @Comment("질문의 답변(GPT)")
    @Column(name = "commentary")
    private String commentary;

    @Comment("내 질문 평가(GPT)")
    @Column(name = "evaluation")
    private String evaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id", insertable = false, updatable = false)
    @MapsId("interviewId")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    @MapsId("questionId")
    private Question question;
}
