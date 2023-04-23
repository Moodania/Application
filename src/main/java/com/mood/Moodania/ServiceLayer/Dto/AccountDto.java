package com.mood.Moodania.ServiceLayer.Dto;

import java.util.UUID;

public record AccountDto(String userName, String email, UUID userId, UUID accountId) {

}
