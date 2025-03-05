package blog_sharing_web.project.comment;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.media.Media;
import blog_sharing_web.project.post.Post;
import blog_sharing_web.project.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Comment extends AbstractEntity<Long> {
    @Column(name="comment",columnDefinition = "TEXT")
    String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    Comment comments;
}
