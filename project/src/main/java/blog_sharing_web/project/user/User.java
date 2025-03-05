package blog_sharing_web.project.user;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.bookmark.Bookmark;
import blog_sharing_web.project.comment.Comment;
import blog_sharing_web.project.message.Message;
import blog_sharing_web.project.notification.Notification;
import blog_sharing_web.project.post.Post;
import blog_sharing_web.project.react.React;
import blog_sharing_web.project.relationship.Relationship;
import blog_sharing_web.project.report.Report;
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

    @Column(name="user_status")
    @Enumerated(EnumType.STRING)
    User_Status userStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    UserProfile user_profile;

    @OneToMany(mappedBy = "creator")
    Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<React> reacts = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Bookmark> bookmarks = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Notification> notifications = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Relationship> relationships = new HashSet<>();

    @OneToMany(mappedBy = "user2")
    Set<Relationship> relationshipWith = new HashSet<>();

    @OneToMany(mappedBy = "sender")
    Set<Message> messagesSend = new HashSet<>();

    @OneToMany(mappedBy = "receiver")
    Set<Message> messagesReceive = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<Report> reports = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    Set<Role> roles = new HashSet<>();
}
