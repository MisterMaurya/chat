package org.anonymous.buddychatter.service.impl;

import org.anonymous.buddychatter.domain.User;
import org.anonymous.buddychatter.domain.projection.FindFriend;
import org.anonymous.buddychatter.dto.AuthenticationDto;
import org.anonymous.buddychatter.repository.UserRepository;
import org.anonymous.buddychatter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<FindFriend> findFriend(Long userId) {
        return userRepository.findByIdIsNot(userId);
    }

    @Override
    public ResponseEntity<Object> authentication(AuthenticationDto authenticationDto) {
        Optional<User> byEmail = userRepository.findByEmail(authenticationDto.getEmail());
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (!authenticationDto.getPassword().equals(user.getPassword())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect email or password!");
            }
            return ResponseEntity.ok(user);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email id not register!");
    }
}
