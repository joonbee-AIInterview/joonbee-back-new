package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "question")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class Question extends AuditEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("GPT 가 만든 질문")
    @Column(name = "gpt_flag", columnDefinition = "TINYINT", nullable = false)
    private byte gptFlag; // byte

    // TODO: COMMENT
    @Column(name = "question_level")
    private int questionLevel;

    @Comment("작성자 gpt 면 gpt")
    @Column(name = "writer", length = 255, nullable = false)
    private String writer;

    @Comment("질문내용")
    @Column(name = "question_content")
    private String questionContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
