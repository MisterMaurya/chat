package org.anonymous.buddychatter.service.impl;

import org.anonymous.buddychatter.domain.FriendRequest;
import org.anonymous.buddychatter.repository.FriendRequestRepository;
import org.anonymous.buddychatter.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {

    private FriendRequestRepository friendRequestRepository;

    @Autowired
    public FriendRequestServiceImpl(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }
    
    @Override
    public void delete(FriendRequest friendRequest) {
        friendRequestRepository.delete(friendRequest);
    }

}
