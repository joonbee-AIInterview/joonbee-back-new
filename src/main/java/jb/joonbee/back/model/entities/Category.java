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
@Table(name = "category")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
public class Category extends AuditEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("카테고리 이름")
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Comment("상위 카테고리 0, 하위 1")
    @Column(name = "category_level", columnDefinition = "TINYINT", nullable = false)
    private byte categoryLevel;

    @Comment("상위 카테고리 id")
    @Column(name = "category_upper_id", nullable = false)
    private int categoryUpperId;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private List<Question> questionList = new ArrayList<>();
}
