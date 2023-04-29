package com.mood.Moodania.ServiceLayer.Dto;

import java.util.UUID;

public record AccountDto(UUID accountId, UUID userId, String username, String email) {

}
