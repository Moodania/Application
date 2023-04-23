package com.mood.Moodania.ServiceLayer.Dto;

import java.util.UUID;

public record SignUpDto(String userName, String email, UUID userId, UUID accountId) {

}
