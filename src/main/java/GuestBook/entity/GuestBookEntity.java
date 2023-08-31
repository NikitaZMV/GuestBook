package GuestBook.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "guestbook")
public class GuestBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Nonnull
    private long id;

    @CreationTimestamp
    @Column(name = "create_datetime", nullable = false)
    @Nonnull
    private Timestamp createDatetime;

    @UpdateTimestamp
    @Column(name = "update_datetime", insertable = false)
    @Nullable
    private Timestamp updateDatetime;

    @Column(name = "username", nullable = false)
    @Nonnull
    private String username;

    @Column(name = "email", nullable = false)
    @Nonnull
    private String email;

    @Column(name = "phone")
    @Nullable
    private String phone;

    @Column(name = "text", nullable = false)
    @Nonnull
    private String text;
}
