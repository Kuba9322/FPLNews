package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.sturnusdev.fantasypremierleaguenews.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String introduction;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;


}
