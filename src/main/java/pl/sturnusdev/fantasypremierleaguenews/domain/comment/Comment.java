package pl.sturnusdev.fantasypremierleaguenews.domain.comment;

import jakarta.persistence.*;
import lombok.Data;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.Article;
import pl.sturnusdev.fantasypremierleaguenews.user.User;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    private LocalDateTime createTime;
}
