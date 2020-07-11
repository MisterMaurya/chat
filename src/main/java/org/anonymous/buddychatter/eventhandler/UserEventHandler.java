package org.anonymous.buddychatter.eventhandler;

import org.anonymous.buddychatter.domain.User;
import org.anonymous.buddychatter.repository.UserRepository;
import org.anonymous.buddychatter.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    private FriendRequestService friendRequestService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public void setFriendRequestService(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @HandleBeforeCreate
    public void handleBeforeSaveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
    }

    @HandleAfterSave
    public void handleAfterSaveUser(User user) {
    }

}
