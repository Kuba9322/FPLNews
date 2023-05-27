package pl.sturnusdev.fantasypremierleaguenews.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String role;
}
