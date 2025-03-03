package blog_sharing_web.project.abstractPack;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;

    @Getter
    @Setter
    @MappedSuperclass
    @FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractEntity <T extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    T id;

    @Column(name="created_by", nullable=false, length=50)
    @CreatedBy
    String createdBy;

    @Column(name="updated_by", nullable=false, length=50)
    @LastModifiedBy
    String updatedBy;
}
