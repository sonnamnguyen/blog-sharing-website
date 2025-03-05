package blog_sharing_web.project.emoji;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.comment.Comment;
import blog_sharing_web.project.react.React;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Emoji  extends AbstractEntity<Integer> {
    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name = "emoji", nullable = false, length = 50)
    String emoji;

    @OneToMany(mappedBy = "emoji")
    Set<React> reacts = new HashSet<>();
}
