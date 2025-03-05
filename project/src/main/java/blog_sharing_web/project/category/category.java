package blog_sharing_web.project.category;

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
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Category extends AbstractEntity<Integer> {

    @Column(name = "name", nullable = false, length = 50)
    String name;

    @ManyToMany
    @JoinTable(
            name = "post_category",
            joinColumns = @JoinColumn(name="categoty_id"),
            inverseJoinColumns = @JoinColumn(name="post_id")
    )
    Set<Post> posts = new HashSet<>();
}
