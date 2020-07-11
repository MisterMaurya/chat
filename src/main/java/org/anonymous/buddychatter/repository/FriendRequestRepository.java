package org.anonymous.buddychatter.repository;

import org.anonymous.buddychatter.domain.FriendRequest;
import org.anonymous.buddychatter.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;
import java.util.Set;

@RepositoryRestResource(path = "friendReq", collectionResourceRel = "friendReq")
public interface FriendRequestRepository extends PagingAndSortingRepository<FriendRequest, Long> {

    @RestResource(exported = false)
    void deleteByReceiverAndSenderIsIn(User receiver, Set<User> sender);

    @Override
    @RestResource(exported = false)
    Optional<FriendRequest> findById(Long id);
}
