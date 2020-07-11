package org.anonymous.buddychatter.domain.projection;

import org.anonymous.buddychatter.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class, name = "userDetails")
public interface UserDetailsProjection {

    @Value("#{target.firstName} #{target.lastName}")
    String getName();

    // Return the age of target entity
    int getAge();

    // Return the email of target entity
    String getEmail();

}
