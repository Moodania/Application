package com.mood.Moodania.DataAccessLayer.Repositories;

import com.mood.Moodania.DataAccessLayer.Entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, UUID> {
    ArrayList<MessageEntity> findByChatId(UUID chatID);
}
