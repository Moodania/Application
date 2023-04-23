package com.mood.Moodania.ServiceLayer.Dto;

import java.util.Map;
import java.util.UUID;

public record LogInDto(String userName, String email, UUID userId, UUID accountId) {

}
