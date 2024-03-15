package jb.joonbee.back.model.entities;


import jakarta.persistence.*;
import jb.joonbee.back.model.base.AuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "member", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
public class Member extends AuditEntity {

    @Id
    @Column(
            name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Comment("이메일")
    @Column(name = "email", nullable = true)
    private String email;

    @Comment("패스워드")
    @Column(name = "password", nullable = false)
    private String password;

    @Comment("닉네임")
    @Column(name = "nick_name", nullable = false)
    private String nickname;

    @Comment("썸네일")
    @Column(name = "thumbnail", nullable = true)
    private String thumbnail;

    @Comment("소셜 로그인 타입")
    @Column(name = "login_type", length = 50, nullable = true)
    private String loginType;

    @Comment("데이터 여부")
    @Column(name = "del_flag", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean delFlag;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "member"
    )
    private List<Interview> interviewList = new ArrayList<Interview>();

}
