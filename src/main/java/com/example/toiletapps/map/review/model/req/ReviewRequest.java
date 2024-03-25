package com.example.toiletapps.map.review.model.req;

import jakarta.validation.constraints.*;

public record ReviewRequest(
        @NotBlank(message = "Review must not be blank")
        String review,
        @Min(value = 1, message = "Rating must be at least {value}")
        @Max(value = 5, message = "Rating must be at most {value}")
        @NotNull(message = "Rating should not be null")
        Integer rating,
        @NotNull(message = "markerId should not be null")
        int markerId
) {
}
