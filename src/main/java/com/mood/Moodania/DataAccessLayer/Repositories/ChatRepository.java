package com.mood.Moodania.DataAccessLayer.Repositories;

import com.mood.Moodania.DataAccessLayer.Entities.ChatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRepository extends CrudRepository<ChatEntity, UUID> {

}
