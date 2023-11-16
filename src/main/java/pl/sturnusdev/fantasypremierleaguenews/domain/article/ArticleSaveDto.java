package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleSaveDto {

    private Long id;
    private String title;
    private String introduction;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    private UserDto author;
    private MultipartFile image;

}
