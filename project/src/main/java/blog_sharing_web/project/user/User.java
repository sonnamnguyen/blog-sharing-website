package blog_sharing_web.project.user;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.role.Role;
import blog_sharing_web.project.user_profile.UserProfile;
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

public class User extends AbstractEntity<Long> {

    @Column(name="username", nullable=false, unique = true, length=50)
    String username;

    @Column(name="password",nullable=false)
    String password_hash;

    @Column(name="email", nullable=false ,unique = true ,length=100)
    String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    UserProfile user_profile;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    Set<Role> roles = new HashSet<>();
}
