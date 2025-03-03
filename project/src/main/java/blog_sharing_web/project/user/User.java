package blog_sharing_web.project.user;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.user_profile.UserProfile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder

public class User extends AbstractEntity<Long> {

    @Column(name="username", nullable=false, unique = true, length=50)
    String username;

    @Column(name="password",nullable=false,length=255)
    String password_hash;

    @Column(name="email", nullable=false ,unique = true ,length=100)
    String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    UserProfile user_profile;
}
