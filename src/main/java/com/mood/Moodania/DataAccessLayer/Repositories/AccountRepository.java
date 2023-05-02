package com.mood.Moodania.DataAccessLayer.Repositories;

import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {
    Optional<AccountEntity> findAccountEntityByEmail(String email);
}
