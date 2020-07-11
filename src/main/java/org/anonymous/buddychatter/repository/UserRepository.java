package org.anonymous.buddychatter.repository;

import org.anonymous.buddychatter.domain.User;
import org.anonymous.buddychatter.domain.projection.FindFriend;
import org.anonymous.buddychatter.domain.projection.UserDetailsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "user", collectionResourceRel = "user", excerptProjection = UserDetailsProjection.class)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {


    List<FindFriend> findByIdIsNot(Long userId);

    @RestResource(exported = false)
    @Override
    void deleteAll();

    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(User entity);

    Optional<User> findByEmail(String email);

}
