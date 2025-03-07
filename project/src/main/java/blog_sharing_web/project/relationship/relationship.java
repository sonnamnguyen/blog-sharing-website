package blog_sharing_web.project.relationship;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.user.User;
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
public class Relationship extends AbstractEntity<Long> {

    @Column(name = "relationship")
    @Enumerated(EnumType.STRING)
    Relation_Type relation_type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id2")
    User user2;

}
