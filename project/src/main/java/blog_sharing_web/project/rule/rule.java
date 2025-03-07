package blog_sharing_web.project.rule;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.report.Report;
import blog_sharing_web.project.role.Role;
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
public class Rule extends AbstractEntity<Integer> {
    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    String description;

    @ManyToMany
    @JoinTable(
            name = "report_rule",
            joinColumns = @JoinColumn(name="rule_id"),
            inverseJoinColumns = @JoinColumn(name="report_id")
    )
    Set<Report> reports = new HashSet<>();
}
