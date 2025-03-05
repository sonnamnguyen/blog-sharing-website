package blog_sharing_web.project.post;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.bookmark.Bookmark;
import blog_sharing_web.project.category.Category;
import blog_sharing_web.project.comment.Comment;
import blog_sharing_web.project.media.Media;
import blog_sharing_web.project.react.React;
import blog_sharing_web.project.report.Report;
import blog_sharing_web.project.tag.Tag;
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
public class Post extends AbstractEntity<Long> {

    @Column(nullable = false)
    String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    String content;

    @OneToMany(mappedBy = "post")
    Set<Media> medias = new HashSet<>();

    @OneToMany(mappedBy = "post")
    Set<React> reacts = new HashSet<>();

    @OneToMany(mappedBy = "post")
    Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "post")
    Set<Bookmark> bookmarks = new HashSet<>();

    @OneToMany(mappedBy = "post")
    Set<Report> reports = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User creator;

    @ManyToMany @JoinTable(
            name = "post_category",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    Set<Category> categories = new HashSet<>();

    @ManyToMany @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    Set<Tag> tags = new HashSet<>();
}
