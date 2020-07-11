package org.anonymous.buddychatter.domain.projection;

import org.anonymous.buddychatter.domain.User;
import org.springframework.beans.factory.annotation.Value;

public interface FindFriend {
    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();

    int getId();

    User.Gender getGender();
}
