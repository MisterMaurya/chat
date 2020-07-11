package org.anonymous.buddychatter.domain.projection;

import org.anonymous.buddychatter.domain.FriendRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "friendRequest", types = FriendRequest.class)
public interface FriendRequestProjection {

    @Value("#{target.sender.id}")
    int getId();

    @Value("#{target.sender.firstName} #{target.sender.lastName}")
    String getName();

    @Value("#{target.sender.age}")
    String getAge();

}
