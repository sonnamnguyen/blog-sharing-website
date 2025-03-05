package blog_sharing_web.project.report;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.post.Post;
import blog_sharing_web.project.rule.Rule;
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
public class Report extends AbstractEntity<Integer> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToMany
    @JoinTable(
            name = "report_rule",
            joinColumns = @JoinColumn(name="report_id"),
            inverseJoinColumns = @JoinColumn(name="rule_id")
    )
    Set<Rule> rules = new HashSet<>();
}
