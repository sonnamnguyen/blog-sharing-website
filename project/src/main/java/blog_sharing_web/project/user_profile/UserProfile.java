package blog_sharing_web.project.user_profile;

import blog_sharing_web.project.abstractPack.AbstractEntity;
import blog_sharing_web.project.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class UserProfile extends AbstractEntity<Long> {

    @Column(name="full_name", length=50)
    String full_name;

    @Column(name="bio", columnDefinition = "TEXT")
    String bio;

    @Column(name="profile_pic")
    String profile_pic;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name="phone_number", unique = true, length=10)
    String phone_number;

    @Column(name="birth_date", length=10)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate birth_date;

    @OneToOne(cascade = CascadeType.ALL)
    User user;


}
