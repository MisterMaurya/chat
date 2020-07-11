package org.anonymous.buddychatter.repository;

import org.anonymous.buddychatter.domain.Conversation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends PagingAndSortingRepository<Conversation, Long> {
}
