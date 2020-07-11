package org.anonymous.buddychatter.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
public class FriendRequest extends Auditable {

    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    boolean accepted;
}
