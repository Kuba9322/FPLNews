package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private Long id;
    private String title;
    private String introduction;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private String author;
}
