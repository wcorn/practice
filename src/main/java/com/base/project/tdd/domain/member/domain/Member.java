package com.base.project.tdd.domain.member.domain;

import com.base.project.tdd.domain.authorization.domain.SocialLogin;
import com.base.project.tdd.domain.authorization.domain.PasswordLogin;
import com.base.project.tdd.domain.comunity.domain.*;
import com.base.project.tdd.global.common.entity.BaseEntity;
import com.base.project.tdd.domain.model.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "member")
    private SocialLogin socialLogin;

    @OneToOne(mappedBy = "member")
    private PasswordLogin passwordLogin;

    @OneToOne(mappedBy = "member")
    private Profile profile;

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<FavoriteBoard> favoriteBoards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<Scrap> scraps = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @ToString.Exclude
    private List<CommentLike> commentLikes = new ArrayList<>();


    //== Create Method ==//
    public static Member createMember(){
        Member member = Member.builder()
                .role(Role.USER)
                .build();
        return member;
    }
    public static Member createAdmin(){
        Member member = Member.builder()
                .role(Role.ADMIN)
                .build();
        return member;
    }

}
