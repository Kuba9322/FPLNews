package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sturnusdev.fantasypremierleaguenews.user.User;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;

import java.time.LocalDateTime;

import static pl.sturnusdev.fantasypremierleaguenews.tools.LocalDateTimeToString.localDateTimeToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String introduction;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private UserDto author;

    public String getCreateTimeString(){
        return localDateTimeToString(createTime);
    }

    public String getModifiedTimeString(){
        return localDateTimeToString(modifiedTime);
    }
}


