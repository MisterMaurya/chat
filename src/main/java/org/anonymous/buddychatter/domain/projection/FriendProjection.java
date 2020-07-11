package org.anonymous.buddychatter.domain.projection;

import org.anonymous.buddychatter.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class, name = "friend")
public interface FriendProjection {

    @Value("#{target.firstName} #{target.lastName}")
    String getName();

    // Return the age of target entity
    int getAge();

}
