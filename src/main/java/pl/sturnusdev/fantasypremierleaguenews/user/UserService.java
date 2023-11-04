package pl.sturnusdev.fantasypremierleaguenews.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDto> findUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .map(UserMapper::map);
    }
    public Optional<User> findUserByUserDto(UserDto userDto) {
        return userRepository
                .findByUsername(userDto.getUsername());
    }
}
