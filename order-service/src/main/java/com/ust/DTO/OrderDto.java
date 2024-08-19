package com.ust.DTO;

import com.ust.validator.ValueInList;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderDto(
        long id,

        @NotNull(message = "value cant be null")
        long book_id,

        int customer_id,

        @NotNull(message = "quantity not null")
        @Size(min = 1)
        int quantity,

        @NotNull(message = "Status not null")
        @ValueInList(allowedValues = {"PENDING","CONFIRMED","CANCELLED"})
        String status
) {
}
