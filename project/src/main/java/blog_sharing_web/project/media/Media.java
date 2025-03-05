package blog_sharing_web.project.media;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.post.Post;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Media extends AbstractEntity<Long> {

    @Column(name = "url", nullable = false)
    String url;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    Media_Type type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    Post post;

}
