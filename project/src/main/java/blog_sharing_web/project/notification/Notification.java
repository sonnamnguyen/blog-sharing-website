package blog_sharing_web.project.notification;

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
public class Notification extends AbstractEntity<Long> {

    @Column(name = "notification", nullable = false, columnDefinition = "TEXT")
    String notification;

    @Column(name = "is_read", nullable = false)
    @Enumerated(EnumType.STRING)
    Notification_Status isRead;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
}
