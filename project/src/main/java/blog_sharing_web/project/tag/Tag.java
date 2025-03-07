package blog_sharing_web.project.tag;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.post.Post;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Tag extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false, length = 50)
    String name;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    Set<Post> posts = new HashSet<>();
}
