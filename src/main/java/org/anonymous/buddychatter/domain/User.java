package org.anonymous.buddychatter.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, scope = User.class)
public class User extends Auditable implements Serializable {

    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull(message = "Please enter valid name")
    private String firstName;
    private String lastName;
    private boolean active;
    private LocalDate dateOfBirth;
    private LocalDateTime lastLogin;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "friend",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "friendId")})
    private Set<User> friends = new HashSet<>();

    @OneToMany(mappedBy = "receiver")
    List<FriendRequest> fr;

   public enum Gender {
        MALE, FEMALE
    }

}
