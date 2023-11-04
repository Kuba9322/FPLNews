package pl.sturnusdev.fantasypremierleaguenews.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private String createTime;
    private String role;
}
