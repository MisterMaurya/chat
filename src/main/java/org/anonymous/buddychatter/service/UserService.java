package org.anonymous.buddychatter.service;

import org.anonymous.buddychatter.domain.projection.FindFriend;
import org.anonymous.buddychatter.dto.AuthenticationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<FindFriend> findFriend(Long userId);

    ResponseEntity<Object> authentication(AuthenticationDto authenticationDto);
}
