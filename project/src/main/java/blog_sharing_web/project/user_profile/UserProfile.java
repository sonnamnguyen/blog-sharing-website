package blog_sharing_web.project.user_profile;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class UserProfile extends AbstractEntity<Long> {

    @Column(name="full_name", nullable=false, length=50)
    String full_name;

    @Column(name="bio",nullable=false, columnDefinition = "TEXT")
    String bio;

    @Column(name="profile_pic", nullable=false)
    String profile_pic;

    @Column(name="gender",nullable=false)
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name="phone_number", nullable=false, length=10)
    String phone_number;

    @Column(name="birth_date", nullable=false, length=10)
    LocalDate birth_date;

    @OneToOne(cascade = CascadeType.ALL)
    User user;
}
