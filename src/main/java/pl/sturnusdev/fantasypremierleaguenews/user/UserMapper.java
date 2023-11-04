package pl.sturnusdev.fantasypremierleaguenews.user;

import static pl.sturnusdev.fantasypremierleaguenews.tools.LocalDateTimeToString.localDateTimeToString;

public class UserMapper {

    public static UserDto map(User user){
        return new UserDto(user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                localDateTimeToString(user.getCreateTime()),
                user.getRole()
        );
    }
}
