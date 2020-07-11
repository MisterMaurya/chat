package org.anonymous.buddychatter.domain.projection;

import org.anonymous.buddychatter.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ff", types = User.class)
public interface FindFriendProjection {

    @Value("#{@userServiceImpl.findFriend(target.getId())}")
    List<FindFriend> getFindFriend();

    @Value("#{@userServiceImpl.findFriend(target.getId()).size()}")
    int getFriendCount();

}
