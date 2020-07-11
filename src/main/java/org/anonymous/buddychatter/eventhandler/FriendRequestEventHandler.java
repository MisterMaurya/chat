package org.anonymous.buddychatter.eventhandler;

import org.anonymous.buddychatter.domain.FriendRequest;
import org.anonymous.buddychatter.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class FriendRequestEventHandler {

    private FriendRequestService friendRequestService;



    @Autowired
    public FriendRequestEventHandler(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @HandleBeforeSave
    void handleBeforeSaveFriendRequest(FriendRequest friendRequest) {
        if (friendRequest.isAccepted()) {
            friendRequest.getReceiver().getFriends().add(friendRequest.getSender());
        }
    }

    @HandleAfterSave
    void handleAfterSaveFriendRequest(FriendRequest friendRequest) {
        friendRequestService.delete(friendRequest);
    }

}
