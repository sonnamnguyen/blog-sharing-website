package blog_sharing_web.project.react;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.emoji.Emoji;
import blog_sharing_web.project.post.Post;
import blog_sharing_web.project.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class React extends AbstractEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emoji_id")
    Emoji emoji;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    Post post;
}
